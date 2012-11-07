;; This file was generated with dalap-cljsbuild from
;;
;; test/clj/savant/test/util_test.clj @ Wed Nov 07 20:59:19 UTC 2012
;;
(ns savant.test.util-test (:require [buster-cljs.core :refer [is]] [savant.util :as u]) (:require-macros [buster-cljs.macros :refer [initialize-buster deftest testing]]))
(do (initialize-buster))
(deftest test-hex-digest (testing "digest of number 1 has always the same value" (is (= "356a192b7913b04c54574d18c28d46e6395428ab" (u/hex-digest 1)) "hex-digest should return always same value for number 1")))