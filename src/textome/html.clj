(ns textome.html
  (:require [pl.danieljanus.tagsoup :as tag]))

(defn get-tags
  [html]
  (filter (partial keyword?) (flatten (tag/parse html))))
