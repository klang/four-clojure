;;Write a function which calculates the sum of the minimal path through a triangle.  The triangle is represented as a collection of vectors.  The path should start at the top of the triangle and move to an adjacent number on the next row until the bottom of the triangle is reached.
(fn [t]
  (loop [t (vec (reverse t))]
    (if (= 1 (count t)) ((t 0)0)
        (recur
         (vec (cons (vec
                     (map +
                          (map #(apply min %) (partition 2 1 (t 0)))
                          (t 1)))
                    (drop 2 t)))))))

;; so damn cool .. 
(fn f
  ([t] (f 0 t))
  ([i [r & t]]
    (+ (r i)
       (if t
         (min (f i t) (f (inc i) t))
         0))))


(let [__
      (fn [t]
        (loop [t (vec (reverse t))]
          (if (= 1 (count t)) ((t 0)0)
              (recur
               (vec (cons (vec (map + (map #(apply min %) (partition 2 1 (t 0))) (t 1))) (drop 2 t)))))))]
  (every? true?
          [(= 7 (__ '([1]
                     [2 4]
                    [5 1 4]
                   [2 3 4 5]))) ; 1->2->1->3
           (= 20 (__ '([3]
                      [2 4]
                     [1 9 3]
                    [9 9 2 4]
                   [4 6 6 7 8]
                  [5 7 3 5 1 4]))) ; 3->4->3->2->7->1]
           ]))

;; can be taken top down or bottom up .. bottom up seems eaiser


(def t '([3] [2 4] [1 9 3] [9 9 2 4] [4 6 6 7 8] [5 7 3 5 1 4]))

(cons (vec (map + (map #(apply min %) (partition 2 1 (t 0))) (t 1))) (drop 2 t))

(map +
     [4 6 6 7 8]
     (map #(apply min %) (partition 2 1 [5 7 3 5 1 4])))


(cons (vec (map + (map #(apply min %) (partition 2 1 (t 0))) (t 1))) (drop 2 t))
(letfn [(f [] 1)] (f))

(defn m [a b] (map + a (map #(apply min %) (partition 2 1 b))))
(m [4 6 6 7 8] [5 7 3 5 1 4])

((vec (reverse '([3] [2 4] [1 9 3] [9 9 2 4] [4 6 6 7 8] [5 7 3 5 1 4]))) 0)
((vec (reverse '([3] [2 4] [1 9 3] [9 9 2 4] [4 6 6 7 8] [5 7 3 5 1 4]))) 1)
(count [7])
([7] 0)

(def t '([3] [2 4] [1 9 3] [9 9 2 4] [4 6 6 7 8] [5 7 3 5 1 4]))
(def t (vec (reverse t)))



(defn f [t]
  (loop [t (vec (reverse t))]
    (if (= 1 (count t)) ((t 0)0)
        (recur
       (vec (cons (vec (map + (map #(apply min %) (partition 2 1 (t 0))) (t 1))) (drop 2 t)))))))


(f '([3] [2 4] [1 9 3] [9 9 2 4] [4 6 6 7 8] [5 7 3 5 1 4]))

