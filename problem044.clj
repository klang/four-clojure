;;Write a function which can rotate a sequence in either direction.

(let [__ #(flatten ((juxt drop take) (mod % (count %2)) %2))]
  (every? true?
          [(= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
           (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
           (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
           (= (__ 1 '(:a :b :c)) '(:b :c :a))
           (= (__ -4 '(:a :b :c)) '(:c :a :b))]
          ))


(take 8 [1 2 3 4 5])

(concat (drop (mod 2 5) [1 2 3 4 5]) (take (mod 2 5) [1 2 3 4 5]))
(concat (drop (mod -2 5) [1 2 3 4 5]) (take (mod -2 5) [1 2 3 4 5]))

(defn rotate [n coll]
  (let [r (mod n (count coll))]
    (concat (drop r coll) (take r coll))))

(defn rotate [n coll]
  (flatten ((juxt drop take) (mod n (count coll)) coll)))

(concat (drop r coll) (take r coll))

(flatten ((juxt drop take) (mod 2 5) [1 2 3 4 5]))
(flatten ((juxt drop take) (mod 2 5) [1 2 3 4 5]))

(mod 6 5)
(mod -4 3)


()

(- 6 (count [1 2 3 4 5]))

(- 6 (count [1 2 3 4 5])) ; =>

(cons [1 2 3] [4 5 6])
(conj [1 2 3] [4 5 6])
(concat [1 2 3] [4 5 6])


(defn rotate [n coll]
  (cond
   (neg? n)))


(+ -4 (count '(:a :b :c)))