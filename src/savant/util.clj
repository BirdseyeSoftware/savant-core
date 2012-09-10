(ns savant.util
  (:import [java.security MessageDigest]))

(defn hex-digest
  "Sensitive implementation that would likely change when running on
   a new instance, this will work as long as the pr-str doesn't
   change for an obj."
  [obj]
  (format "%x" (BigInteger. 1 (.digest (MessageDigest/getInstance "SHA1")
                                       (.getBytes (pr-str obj))))))

(defn with-meta-merge [obj meta-map]
    (with-meta obj (merge (meta obj) meta-map)))

(defn named? [s]
  (or (string? s) (instance? clojure.lang.Named s)))
