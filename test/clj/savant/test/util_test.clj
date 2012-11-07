^{:cljs
  '(ns savant.test.util-test
    (:require [buster-cljs.core :refer [is]]
              [savant.util :as u])
    (:require-macros [buster-cljs.macros
                      :refer [initialize-buster deftest testing]]))}
(ns savant.test.util-test
  (:require [clojure.test :refer [deftest testing is]])
  (:require [savant.util :as u]))

#_(:cljs
(initialize-buster))

(deftest test-hex-digest
  ;; testing both for clj && cljs
  (testing "digest of number 1 has always the same value"
    (is (= "356a192b7913b04c54574d18c28d46e6395428ab"
           (u/hex-digest 1))
        "hex-digest should return always same value for number 1")))
