(defproject savant-core "0.1.0-SNAPSHOT"
  :description "Event store interface for Clojure"
  :url ""
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.4.0"]
                 [slingshot "0.10.3"]
                 [buster-cljs "0.1.0-SNAPSHOT"]]

  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.1"]]}}

  :plugins [[lein-cljsbuild "0.2.9"]
            [lein-dalap "0.1.0-SNAPSHOT"]]
  :hooks [leiningen.dalap]

  :source-paths ["src/clj" "src/cljs"]
  :test-paths ["test/clj" "test/cljs"]

  :cljsbuild
  {:builds
   [{:id "dev"
     :source-path "src/cljs"
     :compiler
     {:output-to "resources/js/savant_core_dev.js"
      :optmizations :whitespace
      :pretty-print true}}
    ;;;
    {:id "browser-test"
     :source-path "test/cljs"
     :notify-command ["./resources/buster_runner.sh"]
     :compiler
     {:externs ["externs/buster.js"]
      :libraries ["resources/js/savant_core_dev.js"]
      :output-to "resources/js/savant_core_browser_test.js"
      :optimizations :simple
      :pretty-print true}}
    ;;;
    {:id "node-test"
     :source-path "test/cljs"
     :notify-command ["./resources/buster_runner.sh"]
     :compiler
     {:externs ["externs/buster.js"]
      :libraries ["resources/js/savant_core_dev.js"]
      :output-to "resources/js/savant_core_node_test.js"
      :optimizations :simple
      :pretty-print true}}]})
