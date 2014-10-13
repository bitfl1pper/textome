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


;;;; Functions below are utility functions borrowed, should be moved to another ns
;;;; for repl play
;;;; ALL BELOW IS TEMPORARY, TODELETE

(defn loadfile
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

(comment
  "copied from scratch buffer #1"
  "Repl play"
  (def commandtxt "home/command.txt")
  (def command-tokens (flatten (map (partial tokens-space) (loadfile command))))
  textome.token> (count (flatten (map (partial tokens-space) (loadfile commandtxt))))
  36848
  (drop-if "" (flatten (map (partial tokens-space) (loadfile commandtxt))))
  textome.token> (count (drop-if "" (flatten (map (partial tokens-space) (loadfile commandtxt)))))
  36329
  textome.token> (- 36848 36329)
  519
  (unique (drop-if "" (flatten (map (partial tokens-space) (loadfile commandtxt)))))
  textome.token> (unique (drop-if "" (flatten (map (partial tokens-space) (loadfile commandtxt)))))
  8229
  "There are 8229 'unique tokens' in this essay. N. Stephenson conveyed his ideas with a token alphabet of size 8229."
  "of course, this includes tokens liek \word\ and \word.\ "

  )
