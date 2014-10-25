(ns textome.token
  (:require [clojure.string :as st]))

(defn tokenize-space
  "Simple tokenizer, splits strings on whitespace.
   Accepts a string, e.g. \"This is test.\"
   Returns a vector of tokens, e.g. [\"This\" \"is\" \"test.\"]"
  [s]
  (st/split s #"\s"))

(defn tokenize-wordchar
  "Simple tokenizer, splits strings on not words.
   Accepts a string, e.g. \"This is test.\"
   Returns a vector of tokens, e.g. [\"This\" \"is\" \"test\"]"
  [s]
  (st/split s #"\W"))


;;;; Functions below are utility functions borrowed, should be moved to another ns
;;;; for repl play
;;;; ALL BELOW IS TEMPORARY, TODELETE

(defn read-file-by-line
  "Load in file for parsing.
   This is from the f.utility lib, change ns.
   fix later"
  [file]
  (with-open [rdr (clojure.java.io/reader file)]
    (doall (line-seq rdr))))

(defn drop-if [value collection]
  "Drops values from a collection if they are equal to "
  (filter #(not= value %) collection))

(defn unique
  "Counts how many distinct items in col."
  [col]
  (count (distinct col)))
