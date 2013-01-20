;;Write a function which calculates factorials.

(let [__ #(apply * (range % 0 -1))]
  (every? true?
    [(= (__ 1) 1)
     (= (__ 3) 6)
     (= (__ 5) 120)
     (= (__ 8) 40320)]
    ))



(reduce * (range 1 (inc 8)))
(reduce * (range 8 0 -1))
(apply * (range 8 0 -1))



