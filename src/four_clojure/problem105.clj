;;Given an input sequence of keywords and numbers, create a map such that each key in the map is a keyword, and the value is a sequence of all the numbers (if any) between it and the next keyword in the sequence.

#(loop [v % m {}]
  (if (empty? v) m
      (recur 
       (drop-while number? (rest v))
       (conj m {(first v) (take-while number? (rest v))}))))

;; chouser
(fn f [[k & v]]
  (if v
    (let [[a b] (split-with number? v)]
      (assoc (f b) k a))
    {}))

(let [__ 
      #(loop [v % m {}]
  (if (empty? v) m
      (recur 
       (drop-while number? (rest v))
       (conj m {(first v) (take-while number? (rest v))}))))]
  (every? true?
          [(= {} (__ []))
           (= {:a [1]} (__ [:a 1]))
           (= {:a [1], :b [2]} (__ [:a 1, :b 2]))
           (= {:a [1 2 3], :b [], :c [4]} (__ [:a 1 2 3 :b :c 4]))]
          ))


(first [:a 1 2 3 :b :c 4])
(take-while number? (rest [:a 1 2 3 :b :c 4]))
(drop-while number? (rest [:a 1 2 3 :b :c 4]))

(let [v [:a 1 2 3 :b :c 4]
      p ((juxt take-while drop-while) number? (rest v))
      m {(first v) (first p)}]
  m
  )

(conj {} {:a 1})

(loop [v [:a 1 2 3 :b :c 4]
       m {}]
  (if (empty? v) m
      (recur 
       (drop-while number? (rest v))
       (conj m {(first v) (take-while number? (rest v))}))))



()