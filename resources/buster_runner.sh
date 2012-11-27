#!/bin/bash

BUSTER_OUTPUT_FILE=/tmp/buster.log

function exec_in_emacs {
    emacsclient -e "$@" 2>&1> /dev/null
}

function run_buster {
    exec_in_emacs '(autotest-mode-begin-notification)'
    buster_output=$(buster-test -r specification -C none -e $1; exit $?)
    buster_exit_code=$?
    # IMPORTANT:
    # given that buster-test no-color option is broken
    # we will add the numbers from the escaping codes
    # in reality the important ones are the last 7 - 1.
    # buster_stats=(0 0 0 0 0 0 0 0 0)
    # buster_stats_failures_index=5
    # buster_stats_error_index=6
    buster_stats=(0 0 0 0 0 0)
    buster_stats_failures_index=3
    buster_stats_error_index=4
    buster_failed=-1
    while read -r line; do
        if [[ $line =~ "ECONNREFUSED" ]] && [[ $1 = browser ]]; then
            exec_in_emacs '(autotest-mode-warning "Start buster-server in order to test browser")'
            exec_in_emacs '(sit-for 1)'
            buster_failed=1
            break
        elif [[ $line =~ "Failed requiring" ]] && [[ $1 = node ]]; then
            exec_in_emacs "(autotest-mode-warning \"$line\")"
            exec_in_emacs '(sit-for 1)'
            buster_failed=1
            break
        elif [[ $line =~ "test cases" ]]; then
            buster_stats=($(echo "$line"                 |
                            grep -Ei '([0-9]+ [a-z]+,?)' |
                            grep -oEi '[0-9]+'))
            break
        fi
    done <<< "$buster_output"
    echo "$buster_output" >> $BUSTER_OUTPUT_FILE
    if [[ $buster_failed -eq 1 ]]; then
        echo 'do nothing...'
    elif [[ ${buster_stats[$buster_stats_failures_index]} > 0 ]] ||
         [[ ${buster_stats[$buster_stats_error_index]} > 0 ]]; then
        exec_in_emacs '(autotest-mode-fail)'
        exec_in_emacs "(progn
                         (save-window-excursion
                           (find-file \"$BUSTER_OUTPUT_FILE\"))
                         (pop-to-buffer \"buster.log\")
                         (end-of-buffer))"
    else
        exec_in_emacs '(autotest-mode-succeed)'
    fi
    return $buster_exit_code
}

if [[ $1 =~ "browser_test" ]]; then
    run_buster browser
elif [[ $1 =~ "node_test" ]]; then
    run_buster node
fi
