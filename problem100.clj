;;Write a function which calculates the <a href="http://en.wikipedia.org/wiki/Least_common_multiple">least common multiple</a>.  Your function should accept a variable number of positive integers or ratios. 

(let [__ (fn [& x] (/ (apply * x) (reduce #(if (= 0 %) %2 (recur (mod %2 %) %)) x)))]
  (every? true?
          [(== (__ 2 3) 6)
           (== (__ 5 3 7) 105)
           (== (__ 1/3 2/5) 2)
           (== (__ 3/4 1/6) 3/2)
           (== (__ 7 5/7 2 3/5) 210)]
          ))

(clojure.contrib.math/lcm 1/3 2/5)

;; gcd #(if (= 0 %) %2 (recur (mod %2 %) %))

(def gcd' #(if (= 0 %) %2 (recur (mod %2 %) %)))

(gcd' 1/3 2/5)

(/ (reduce * [7 5/7 2 3/5]) (reduce gcd' [7 5/7 2 3/5]))

(== 210 ((fn [x] (/ (reduce * x) (reduce gcd' x))) [7 5/7 2 3/5]))
(== 210 ((fn [x] (/ (reduce * x) (reduce #(if (= 0 %) %2 (recur (mod %2 %) %)) x))) [7 5/7 2 3/5]))
(== 105 ((fn [& x] (/ (reduce * x) (reduce #(if (= 0 %) %2 (recur (mod %2 %) %)) x))) 5 3 7))