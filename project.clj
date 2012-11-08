(defproject savant-core "0.1.0-SNAPSHOT"
  :description "Event store interface for Clojure"
  :url ""
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [;; clojure dependencies
                 [org.clojure/clojure "1.4.0"]
                 [slingshot "0.10.3"]
                 ;; clojurescript dependencies
                 [org.clojure/google-closure-library "0.0-1376-2"]
                 [buster-cljs "0.1.0-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "0.2.9"]
            [lein-dalap-cljsbuild "0.1.0-SNAPSHOT"]]
  :hooks [leiningen.dalap-cljsbuild]

  :source-paths ["src/clj" "src/cljs"]
  :test-paths ["test/clj" "test/cljs"]

  :cljsbuild
  {:builds
   [{:id :dev
     :source-path "src/cljs"
     :dalap
     {:paths
      {"src/clj/savant/core.clj" "src/cljs/savant/core.cljs"
       "src/clj/savant/util.clj" "src/cljs/savant/util.cljs"
       "src/clj/savant/store/memory.clj" "src/cljs/savant/store/memory.cljs"}}
     :compiler
     {:output-to "resources/js/savant_core_dev.js"
      :optmizations :whitespace
      :pretty-print true}}
    ;;;
    {:id :browser-test
     :source-path "test/cljs"
     :dalap
     {:paths
      {"test/clj/savant/test/util_test.clj"
       "test/cljs/savant/test/util_test.cljs"

       "test/clj/savant/test/store_spec.clj"
       "test/cljs/savant/test/store_spec.cljs"

       "test/clj/savant/test/store/memory_test.clj"
       "test/cljs/savant/test/store/memory_test.cljs"}}
     :compiler
     {:externs ["externs/buster.js"]
      :libraries ["resources/js/savant_core_dev.js"]
      :output-to "resources/js/savant_core_browser_test.js"
      :optimizations :simple
      :pretty-print true}}
    ;;;
    {:id :node-test
     :source-path "test/cljs"
     :compiler
     {:externs ["externs/buster.js"]
      :libraries ["resources/js/savant_core_dev.js"]
      :output-to "resources/js/savant_core_node_test.js"
      :optimizations :simple
      :pretty-print true}}]})
