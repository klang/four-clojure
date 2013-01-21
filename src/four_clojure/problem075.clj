;;Two numbers are coprime if their greatest common divisor equals 1.  Euler's totient function f(x) is defined as the number of positive integers less than x which are coprime to x.  The special case f(1) equals 1.  Write a function which calculates Euler's totient function.
(comment
  (fn [n]
    (let [gcd #(if (= 0 %) %2 (recur (mod %2 %) %))]
      (loop [tot 0, pos (- n 1)]
        (if (>= pos 0)
          (if (= 1 (gcd n pos))
            (recur (+ tot 1) (- pos 1))
            (recur tot (- pos 1)))
          tot))))

  ;; amazing
  (fn [a]
    (count
     (for [b (range a)
           :when (not-any? #(= 0 (rem a %) (rem b %)) (range 2 a))]
       b)))
  )

(let [__
      (fn [n]
        (let [g #(if (= 0 %) %2 (recur (mod %2 %) %))]
          (loop [t 0, p (- n 1)]
            (if (>= p 0)
              (if (= 1 (g n p))
                (recur (+ t 1) (- p 1))
                (recur t (- p 1)))
              t))))]
  (every? true?
          [(= (__ 1) 1)
           (= (__ 10) (count '(1 3 7 9)) 4)
           (= (__ 40) 16)
           (= (__ 99) 60)])
  )


(def gcd #(if (= 0 %) %2 (recur (mod %2 %) %)))

(defn totient [n]
  (loop [tot 0, pos (- n 1)]
    (if (>= pos 0)
      (if (= 1 (gcd n pos))
	(recur (+ tot 1) (- pos 1))
	(recur tot (- pos 1)))
      tot)))

(totient 1)
(= (totient 10) (count '(1 3 7 9)) 4)
(totient 10)
(totient 40)
(totient 99)





