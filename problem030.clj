;;Write a function which removes consecutive duplicates from a sequence.

(let [__ #(map first (partition-by identity %))]
  (every? true?
          [(= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
           (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
           (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))]
          ))

;; take if different from last,
;; drop if it is equal to last

(map first (partition-by identity "Leeeeeerrroyyy"))
;;#(map first (partition-by identity %))
;;#(map last (partition-by identity %))   <-- fucking brilliant!


