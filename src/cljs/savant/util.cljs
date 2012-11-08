;; This file was generated with dalap-cljsbuild from
;;
;; src/clj/savant/util.clj @ Thu Nov 08 22:45:33 UTC 2012
;;
(ns savant.util (:require [goog.crypt :as gcrypt] [goog.crypt.Sha1 :as gsha1]))
(defn hex-digest "Sensitive implementation that would likely change when running on\n   a new instance, this will work as long as the pr-str doesn't\n   change for an obj." [obj] (gcrypt/byteArrayToHex (.digest (doto (gcrypt/Sha1.) (.update (pr-str obj))))))
(defn throw+ [obj msg] (let [e (js/Error. msg)] (set! (.-type e) (:type obj)) (throw e)))
(defn with-meta-merge [obj meta-map] (with-meta obj (merge (meta obj) meta-map)))
(defn named? [s] (or (string? s) (instance? cljs.core.Named s)))