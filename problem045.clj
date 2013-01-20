;;The iterate function can be used to produce an infinite lazy sequence.

(let [__ [1 4 7 10 13]]
  (every? true?
          [(= __ (take 5 (iterate #(+ 3 %) 1)))]
          ))