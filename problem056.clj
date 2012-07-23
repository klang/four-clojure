;;Write a function which removes the duplicates from a sequence. Order of the items must be maintained.


;; preserve order of elements

(let [__ #(loop [coll % seen #{} return []]
    (if (empty? coll)
      return
      (if (contains? seen (first coll))
        (recur (rest coll)
               seen
               return)
        (recur (rest coll)
               (conj seen (first coll))
               (conj return (first coll)))
        )
      )
    )]
  (every? true?
            [(= (__ [1 2 1 3 1 2 4]) [1 2 3 4])
             (= (__ [:a :a :b :b :c :c]) [:a :b :c])
             (= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
             (= (__ (range 50)) (range 50))]))
  

;; reduce #(if (some {%2 1} %) % (conj % %2)) []

(loop [x (rest %) c [(first %)]]
  (if (empty? x)
    c
    (if ()))
  )

(vec (into (sorted-set) [1 2 1 3 1 2 4]))
(vec (into (sorted-set) [:a :a :b :b :c :c]))
#(vec (into (sorted-set) %))

(vec (set '([2 4] [1 2] [1 3] [1 3])))
(map #() '([2 4] [1 2] [1 3] [1 3]))

(#(map last (partition-by identity %)) [1 2 1 3 1 2 4])
(vec (set [1 2 1 3 1 2 4]))
(vec (map first (partition-by identity %)) [:a :a :b :b :c :c])
(comp vec set)
#(vec (set %))

(#(loop [coll % seen #{} return []]
    (if (empty? coll)
      return
      (if (contains? seen (first coll))
        (recur (rest coll)
               seen
               return)
        (recur (rest coll)
               (conj seen (first coll))
               (conj return (first coll)))
        )
      )
    )
 '([2 4] [1 2] [1 3] [1 3])
 )

(#(loop [c % s #{} r []]
    (if (empty? c)
      r
      (if (contains? s (first c))
        (recur (rest c) s r)
        (recur (rest c) (conj s (first c)) (conj r (first c))))))
 '([2 4] [1 2] [1 3] [1 3])
 )


