;;A number is "perfect" if the sum of its divisors equal the number itself.  6 is a perfect number because 1+2+3=6.  Write a function which returns true for perfect numbers and false otherwise.

(let [__ #(= % (reduce
        +
        (into
         #{}
         (flatten
          (map
           (fn [x d]
             (loop [x x y [1] d d]
               (let [x (/ x d)]
                 (if (instance? Long x) (recur x (conj y x) d) y))))
           (cycle [%]) (range 2 %))))))]
  (every? true?
          [(= (__ 6) true)
           (= (__ 7) false)
           (= (__ 496) true)
           (= (__ 500) false)
           (= (__ 8128) true)]
          ))
;; bad bad BAD!!

;; mod .. crap


;; #(= % (apply + (for [i (range 1 %) :when (= 0 (mod % i))] i)))
;; (fn [n] (= (reduce + (remove #(< 0 (mod n %)) (range 1 n))) n))

(#(loop [x % s #{} y (range 1 x)]
    (if (instance? Long x)
      (recur (/ x (first y))
             (conj s (/ x (first y)))
             (rest y))
      s
      )) 8128)


(#(loop [x % s #{} y 2]
    (if (= x 1)
      s
      (let [n (/ x 1)]
        (if (instance? Long n)
          (recur n (conj s n) (inc y))
             
             )))) 8128)

(instance? int 8128)
(conj #{1 2 3 4} 5)

(type 8128.3)
`(loop []
   (when ~test
     ~@body
     (recur)))

(loop [x 8128 y 2] (let [r (/ x y)]) (when (instance? Long x)))




(#(= % (reduce
        +
        (into
         #{}
         (flatten
          (map
           (fn [x d]
             (loop [x x y [1] d d]
               (let [x (/ x d)]
                 (if (instance? Long x) (recur x (conj y x) d) y))))
           (cycle [%]) (range 2 %)))))) 8128)


#{32 64 4064 2 4 8 16 2032 1016 508 254 127}
#{32 64 4064 1 2 4 8 16 2032 1016 508 254 127}
user> (divisors 8128)
#{32 64 8128 4064 1 2 4 8 16 2032 1016 508 254 127}

