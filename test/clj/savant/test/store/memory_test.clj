(ns savant.test.store.memory-test
  (:require [clojure.test :refer :all]
            [savant.test.store-spec :refer :all]
            [savant.store.memory]))

(deftest memory-event-store-tests
  (testing "testing memory event store:"
    (let [ns 'savant.store.memory
          valid-opts {:name "foo"}
          invalid-opts {:invalid "option"}]
      (get-event-store-constructor-tests ns valid-opts invalid-opts)
      (event-store-protocol-tests ns valid-opts)
      (event-stream-protocol-tests ns valid-opts))))
