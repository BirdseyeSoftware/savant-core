(defproject com.birdseye-sw/savant-core "0.1.0"
  :description "Event store interface for Clojure"
  :url "http://birdseye-sw.com/oss/savant-core/"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [slingshot "0.10.3"]
                 [com.birdseye-sw/buster-cljs "0.1.0"]]

  :plugins [[lein-cljsbuild "0.2.9"]
            [com.birdseye-sw/lein-dalap "0.1.0"]]
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
