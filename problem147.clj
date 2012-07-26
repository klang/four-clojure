;;Write a function that, for any given input vector of numbers, returns an infinite lazy sequence of vectors, where each next one is constructed from the previous following the rules used in <a href="http://en.wikipedia.org/wiki/Pascal's_triangle">Pascal's Triangle</a>. For example, for [3 1 2], the next row is [3 4 3 2].

(let [__ "fd"]
  (every? true?
          [(= (second (__ [2 3 2])) [2 5 5 2])
           (= (take 5 (__ [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])
           (= (take 2 (__ [3 1 2])) [[3 1 2] [3 4 3 2]])
           (= (take 100 (__ [2 4 2])) (rest (take 101 (__ [2 2]))))]
          ))
;; iterate (fn [c] `[~(first c) ~@(map #(apply + %) (partition 2 1 c)) ~(last c)])
;; iterate (fn [c] `[~(c 0) ~@(map #(apply + %) (partition 2 1 c)) ~(last c)])
;; iterate (fn [c] `[~(c 0) ~@(map #(apply +' %) (partition 2 1 c)) ~(last c)])

;; chouser => wow, amazing =>   iterate #(map + `(0 ~@%) `(~@% 0))

(every? true?
        [(= (second (iterate (fn [c] `[~(first c) ~@(map #(apply + %) (partition 2 1 c)) ~(last c)]) [2 3 2])) [2 5 5 2])
         
         (= (take 5 (iterate (fn [c] `[~(first c) ~@(map #(apply + %) (partition 2 1 c)) ~(last c)]) [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])
         (= (take 2 (iterate (fn [c] `[~(first c) ~@(map #(apply + %) (partition 2 1 c)) ~(last c)]) [3 1 2])) [[3 1 2] [3 4 3 2]])
           
         (= (take 100 (iterate (fn [c] `[~(first c) ~@(map #(apply +' %) (partition 2 1 c)) ~(last c)]) [2 4 2])) (rest (take 101 (iterate (fn [c] `[~(first c) ~@(map #(apply +' %) (partition 2 1 c)) ~(last c)]) [2 2]))))]
          )

(take 2
      (iterate
         (fn [c]
           `[~(first c) ~@(map #(apply + %) (partition 2 1 c)) ~(last c)]) [3 1 2]))
(take 66
      (iterate
         (fn [c]
           `[~(first c) ~@(map #(apply +' %) (partition 2 1 c)) ~(last c)]) [2 4 2]))


( (fn [c]
    `[~(c 0) ~@(map #(apply + %) (partition 2 1 c)) ~(last c)]) [2 3 2])





( (fn p [c]
    `[~(first c) ~@(map + (p (- c 1)) (next (p (- c 1)))) ~(last c)]) [2 3 2])




(map #(apply + %) (partition 2 1 [3 1 2]))


(take 5 ( (fn[s] (iterate (fn [r] (vec (concat s (map #(apply + %) (partition 2 1 r)) s ))) [1])) [2 3 2] ))

(let [__ ]
  (every? true?
          [(= (__ 1) [1])
           (= (map __ (range 1 6))
              [     [1]
                    [1 1]
                    [1 2 1]
                    [1 3 3 1]
                    [1 4 6 4 1]])
           (= (__ 11)
              [1 10 45 120 210 252 210 120 45 10 1])]
          ))
