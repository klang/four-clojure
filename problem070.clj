;;Write a function that splits a sentence up into a sorted list of words.  Capitalization should not affect sort order and punctuation should be ignored.

;; #(sort-by (fn [w] (.toLowerCase w)) (re-seq #"\w+" %))

(let [__
(fn [s] (sort #(.compareToIgnoreCase % %2)
              (map #(clojure.string/replace % #"[-\W]+" "" ) (.split #" " s))))]
  (every? true?
          [(= (__  "Have a nice day.")
              ["a" "day" "Have" "nice"])
           (= (__  "Clojure is a fun language!")
              ["a" "Clojure" "fun" "is" "language"])
           (= (__  "Fools fall for foolish follies.")
              ["fall" "follies" "foolish" "Fools" "for"])]
          ))

(sort (comp compare (partial (format "%S")))  (.split #" " "Have a nice day."))

(sort (map  #(.toLowerCase %) (.split #" " "Fools fall for foolish follies.")))
(sort #(.compareToIgnoreCase % %2) (.split #" " "Fools fall for foolish follies."))

(sort #(.compareToIgnoreCase % %2)
      (map #(clojure.string/replace % #"[-\W]+" "" )
           (.split #" " "Fools fall for foolish follies.")))

( (fn [s] (sort #(.compareToIgnoreCase % %2)
          (map #(clojure.string/replace % #"[-\W]+" "" )
               (.split #" " s)))) "Fools fall for foolish follies.")

;; remove non alfa characters
;; sort by lower case
(clojure.string/replace "abcad." #"[-\W]+" "" )

(.replace "abcad." #"([a-z]+)" "" )

;;(re-seq #"\w+"  "Fools fall for foolish follies.")