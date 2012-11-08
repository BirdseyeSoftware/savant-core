;; This file was generated with dalap-cljsbuild from
;;
;; test/clj/savant/test/store/memory_test.clj @ Thu Nov 08 22:49:23 UTC 2012
;;
(ns savant.test.store.memory-test (:require [buster-cljs.core :refer [is]] [savant.test.store-spec :refer [get-event-store-constructor-tests event-store-protocol-tests event-stream-protocol-tests]] [savant.store.memory :as m]) (:require-macros [buster-cljs.macros :refer [initialize-buster deftest describe]]))
(do (initialize-buster))
(deftest memory-event-store-tests (describe "testing memory event store:" (let [ns (js* "savant.store.memory") valid-opts {:name "foo"} invalid-opts {:invalid "option"}] (get-event-store-constructor-tests ns valid-opts invalid-opts) (event-store-protocol-tests ns valid-opts) (event-stream-protocol-tests ns valid-opts))))