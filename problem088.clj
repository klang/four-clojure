;;Write a function which returns the symmetric difference of two sets.  The symmetric difference is the set of items belonging to one but not both of the two sets.
;; #(into (set (remove %2 %)) (remove % %2))
;; #(set (concat (remove %2 %) (remove % %2)))
;; #(set (concat (remove % %2) (remove %2 %)))


(let [__ #(clojure.set/difference
           (clojure.set/union % %2)
           (clojure.set/intersection % %2))]
  (every? true?
          [(= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
           (= (__ #{:a :b :c} #{}) #{:a :b :c})
           (= (__ #{} #{4 5 6}) #{4 5 6})
           (= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})]
          ))

(clojure.set/difference
 (clojure.set/union #{1 2 3 4 5 6} #{1 3 5 7})
 (clojure.set/intersection #{1 2 3 4 5 6} #{1 3 5 7}))

(#(clojure.set/difference
   (clojure.set/union % %2)
   (clojure.set/intersection % %2)) #{1 2 3 4 5 6} #{1 3 5 7})

