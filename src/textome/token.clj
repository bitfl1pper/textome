(ns textome.token
  (:require [clojure.string :as st]))

(defn tokens-space
  "Simple tokenizer, splits strings on whitespace.
   Accepts a string, e.g. \"This is test.\"
   Returns a vector of tokens, e.g. [\"This\" \"is\" \"test.\"]"
  [s]
  (st/split s #"\s"))

(defn tokens-word
  "Simple tokenizer, splits strings on not words.
   Accepts a string, e.g. \"This is test.\"
   Returns a vector of tokens, e.g. [\"This\" \"is\" \"test\"]"
  [s]
  (st/split s #"\W"))
