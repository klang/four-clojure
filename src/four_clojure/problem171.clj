;;Write a function that takes a sequence of integers and returns a sequence of "intervals".  Each interval is a a vector of two integers, start and end, such that all integers between start and end (inclusive) are contained in the input sequence.

( (fn [s]
    (loop [x (sort s) p []]
      (if (empty? x) p
          (let 
              [a (split-with 
                  (partial > 2) 
                  (map #(- (nth % 1)(first %)) 
                       (partition 2 1 x)))
               n (inc (count (first a)))]
            (recur (drop n x) (conj p (apply (juxt min max) (take n x))))))))
[19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])

(let [__ (fn [s]
    (loop [x (sort s) p []]
      (if (empty? x) p
          (let 
              [a (split-with 
                  (partial > 2) 
                  (map #(- (nth % 1)(first %)) 
                       (partition 2 1 x)))
               n (inc (count (first a)))]
            (recur (drop n x) (conj p (apply (juxt min max) (take n x))))))))]
  (every? true?
          [(= (__ [1 2 3]) [[1 3]])
           (= (__ [10 9 8 1 2 3]) [[1 3] [8 10]])
           (= (__ [1 1 1 1 1 1 1]) [[1 1]])
           (= (__ []) [])
           (= (__ [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])
              [[1 4] [6 6] [9 11] [13 17] [19 19]])
           ])
  )

(sort [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])

(1 2 2 2 2 3 4 4 6 9 10 11 13 13 13 14 15 16 17 19)

(split-with (partial > 2) 
            (map #(- (nth % 1)(first %)) 
                 (partition 2 1 '(1 2 2 2 2 3 4 4 6 9 10 11 13 13 13 14 15 16 17 19))))

(let [s (sort [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])]
  (loop [x s p []]
    (if (empty? x) p
        (let 
            [a (split-with 
                (partial > 2) 
                (map #(- (nth % 1)(first %)) 
                     (partition 2 1 x)))
             n (inc (count (first a)))]
          (recur (drop n x) (conj p (take n x)))))))

(conj [] [123])x
(conj [[123]] [345])

(map #(- (nth % 1)(first %)) 
           (partition 2 1 '(1 2 2 2 2 3 4 4 6 9 10 11 13 13 13 14 15 16 17 19)))

(map #(vector % %1) 
     '(1 2 2 2 2 3 4 4 6 9 10 11 13 13 13 14 15 16 17 19)
  (map #(- (nth % 1)(first %)) 
           (partition 2 1 '(1 2 2 2 2 3 4 4 6 9 10 11 13 13 13 14 15 16 17 19)))    
        )

(map  #(apply (juxt min max) %) 
      (map #(map first %)
           (partition-by #(< 1 (second %)) 
                         (map #(vector % %2) 
                              '(1 2 2 2 2 3 4 4 6 9 10 11 13 13 13 14 15 16 17 19)
                              '(1 0 0 0 1 1 0 2 3 1  1  2  0  0  1  1  1  1  2  0)))))

((fn [x]
   (map  #(apply (juxt min max) %) 
         (map #(map first %)
              (partition-by 
               #(< 1 (second %)) 
               (map #(vector % %2) 
                    x
                    (map #(- (nth % 1)(first %)) 
           (partition 2 1 x)))))))
 '(1 2 2 2 2 3 4 4 6 9 10 11 13 13 13 14 15 16 17 19))

(vector 1 2)
(= 1 (last []))

(filter number? (map #(if (< 1 (- (nth % 1)(first %))) %2) 
             (partition 2 1 '(1 2 2 2 2 3 4 4 6 9 10 11 13 13 13 14 15 16 17 19))
             '(1 2 2 2 2 3 4 4 6 9 10 11 13 13 13 14 15 16 17 19)))
'(4 6 11 17)

(take-while (partial >= 4) '(1 2 2 2 2 3 4 4 6 9 10 11 13 13 13 14 15 16 17 19))

[[1 2 2 2 2 3 4 4] [6] [9 10 11] [13 13 13 14 15 16 17] [19]]


(let [s (sort [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])]
  (loop [x s p []]
    (if (empty? x) p
        (let 
            [a (split-with 
                (partial > 2) 
                (map #(- (nth % 1)(first %)) 
                     (partition 2 1 x)))
             n (inc (count (first a)))]
          (recur (drop n x) (conj p (apply (juxt min max) (take n x))))))))
(sort [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])

( (fn [s]
    (loop [x (sort s) p []]
      (if (empty? x) p
          (let 
              [a (split-with 
                  (partial > 2) 
                  (map #(- (nth % 1)(first %)) 
                       (partition 2 1 x)))
               n (inc (count (first a)))]
            (recur (drop n x) (conj p (apply (juxt min max) (take n x))))))))
[19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])

(map  #(apply (juxt min max) %) 
      [[1 2 2 2 2 3 4 4] [6] [9 10 11] [13 13 13 14 15 16 17] [19]])



