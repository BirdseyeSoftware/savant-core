;; This file was generated with dalap-cljsbuild from
;;
;; src/clj/savant/util.clj @ Wed Nov 07 19:04:52 UTC 2012
;;
(ns savant.util (:require [goog.crypt :as gcrypt] [goog.crypt.Sha1 :as gsha1]))
(defn hex-digest "Sensitive implementation that would likely change when running on\n   a new instance, this will work as long as the pr-str doesn't\n   change for an obj." [obj] (gcrypt/byteArrayToHex (.digest (doto (gcrypt/Sha1.) (.update (pr-str obj))))))
(defn with-meta-merge [obj meta-map] (with-meta obj (merge (meta obj) meta-map)))
(defn named? [s] (or (string? s) (instance? cljs.core.Named s)))