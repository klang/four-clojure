;;Write a function which reverses the interleave process into x number of subsequences.

;; cgrand: #(apply map list (partition %2 %))
;; klang: #(for[i (range %2)](map(fn[r](nth r i))(partition %2 %)))

(let [__ #(for[i (range %2)](map(fn[r](nth r i))(partition %2 %)))]
  (every? true?
          [(= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
           (= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
           (= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))]
          ))


(interleave '(0 3 6) '(1 4 7) '(2 5 8) )

(map (juxt first second) (partition (/ (count [1 2 3 4 5 6]) 2) [1 2 3 4 5 6]))

(partition 2 [1 2 3 4 5 6])
[ (map #(nth % 0) (partition 3 (range 9)))
  (map #(nth % 1) (partition 3 (range 9)))
  (map #(nth % 2) (partition 3 (range 9)))]

[ (map #(nth % 0) (partition 3 (range 9)))
  (map #(nth % 1) (partition 3 (range 9)))
  (map #(nth % 2) (partition 3 (range 9)))]

[ (map #(nth % 0) (partition 5 (range 10)))
  (map #(nth % 1) (partition 5 (range 10)))
  (map #(nth % 2) (partition 5 (range 10)))
  (map #(nth % 3) (partition 5 (range 10)))
  (map #(nth % 4) (partition 5 (range 10)))]

(for [i (range 5) ] (map #(nth % i) (partition 5 (range 10))))
(for [i (range 5) ] (map #(nth % i) (partition 5 (range 10))))

(for [i (range 3) ] (map #(nth % i) (partition 3 (range 9))))
(for [i (range 2) ] (map #(nth % i) (partition 2 [1 2 3 4 5 6])))

((fn [a b] (for [i (range b) ] (map #(nth % i) (partition b a)))) [1 2 3 4 5 6] 2)
((fn [a b] (for [i (range b) ] (map #(nth % i) (partition b a)))) (range 9) 3)
((fn [a b] (for [i (range b) ] (map #(nth % i) (partition b a)))) (range 10) 5)

((fn[a b](for [i (range b)](map #(nth % i)(partition b a))))[1 2 3 4 5 6] 2)
(#(for[i (range %2)](map(fn[r](nth r i))(partition %2 %)))[1 2 3 4 5 6] 2)

(#(for[i (range %2)](map(fn[r](nth r i))(partition %2 %)))[1 2 3 4 5 6] 2)
