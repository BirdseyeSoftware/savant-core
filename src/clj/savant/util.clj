(ns savant.util
  ^{:cljs
    (:require [goog.crypt :as gcrypt]
              [goog.crypt.Sha1 :as gsha1])}
  ;; clj version
  (:import [java.security MessageDigest]))

(defn hex-digest
  "Sensitive implementation that would likely change when running on
   a new instance, this will work as long as the pr-str doesn't
   change for an obj."
  [obj]
  ^{:cljs
    '(gcrypt/byteArrayToHex
      (.digest (doto (gcrypt/Sha1.)
                 (.update  (pr-str obj)))))}
  ;; clj version
  (format "%x" (BigInteger. 1 (.digest (MessageDigest/getInstance "SHA1")
                                       (.getBytes (pr-str obj))))))


(defn with-meta-merge [obj meta-map]
    (with-meta obj (merge (meta obj) meta-map)))

(defn named? [s]
  (or (string? s) (instance? clojure.lang.Named s)))
