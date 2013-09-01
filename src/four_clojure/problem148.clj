;;<p>Write a function which calculates the sum of all natural numbers under <i>n</i> (first argument) which are evenly divisible by at least one of <i>a</i> and <i>b</i> (second and third argument). Numbers <i>a</i> and <i>b</i> are guaranteed to be <a href="http://en.wikipedia.org/wiki/Coprime">coprimes</a>.</p>

<p>Note: Some test cases have a very large <i>n</i>, so the most obvious solution will exceed the time limit.</p>

;; http://mathforum.org/library/drmath/view/57919.html
;; using this idea:
;;      (1 + 100) + (2 + 99) + (3 + 98) + . . . . + (50 + 51) = ?
;; we try to rearrange the terms we are working on and create a formula
;; for the range sum.


(defn range-sum [max step]
  (let [x (dec max)
        last-in-range (- x (mod x step))]
    (* (+ last-in-range step)
       (/ (/ last-in-range step) 2))))

(defn range-sum [max step]
  (let [x (dec max)
        last-in-range (- x (mod x step))]
    (* (+ last-in-range step)
       (/ last-in-range step 2))))

(defn da-sum [max a b]
  (- (+ (range-sum max a) (range-sum max b)) (range-sum max (* a b))))


(defn da-sum [max a b]
  (let [range-sum (fn [max step]
                     (let [x (dec max)
                           last-in-range (- x (mod x step))]
                       (* (+ last-in-range step)
                          (/ last-in-range step 2))))]
        (- (+ 
            (range-sum max a) 
            (range-sum max b)) 
           (range-sum max (* a b)))
        )
  )
(defn da-sum [max a b]
  (let [range-sum (fn [step]
                     (let [x (dec max)
                           last-in-range (- x (mod x step))]
                       (* (+ last-in-range step)
                          (/ last-in-range step 2))))]
        (- (+ 
            (range-sum a) 
            (range-sum b)) 
           (range-sum (* a b)))
        )
  )

(defn da-sum [m a b]
  (let [R (fn [s]
            (let [x (dec m)
                  y (- x (mod x s))]
              (* (+ y s)
                 (/ y s 2))))]
        (- (+ 
            (R a) 
            (R b)) 
           (R (* a b)))))


(fn [m a b]
 (let [R (fn [s]
           (let [x (dec m)
                 y (- x (mod x s))]
             (* (+ y s)
                (/ y s 2))))]
   (- (+ (R a) (R b)) 
      (R (* a b)))))

(let [__ (fn [m a b]
 (let [R (fn [s]
           (let [x (dec m)
                 y (- x (mod x s))]
             (* (+ y s)
                (/ y s 2))))]
   (- (+ (R a) (R b)) 
      (R (* a b)))))]
  (every? true?
          [(= 0 (__ 3 17 11))
           (= 23 (__ 10 3 5))
           (= 233168 (__ 1000 3 5))
           (= "2333333316666668" (str (__ 100000000 3 5)))
           (= "110389610389889610389610"
              (str (__ (* 10000 10000 10000) 7 11)))
           (= "1277732511922987429116"
              (str (__ (* 10000 10000 10000) 757 809)))
           (= "4530161696788274281"
              (str (__ (* 10000 10000 1000) 1597 3571)))]
          ))
(comment
  (reduce + (filter #(or (zero? (mod % 3)) (zero? (mod % 5))) (range 10)))
  (reduce + (filter #(or (zero? (mod % 3)) (zero? (mod % 5))) (range 10000)))

   (reduce + (filter #(or (zero? (mod % 3)) (zero? (mod % 5))) (range 10000)))

   (time (+ (reduce + (range 3 100000000 3))
            (reduce + (filter #(< 0 (mod % 3)) (range 5 100000000 5)))))


  (time (reduce + (filter #(or (zero? (mod % 3)) 
                               (zero? (mod % 5))) 
                          (range 100000000))))

)
;; "Elapsed time: 23879.703 msecs"
;; 2333333316666668
(comment
  (time (+ (reduce + (range 3 100000000 3))
           (reduce + (filter #(< 0 (mod % 3)) (range 5 100000000 5)))))
  ;;"Elapsed time: 7583.716 msecs"
  ;;2333333316666668
 
  (time ( (range 3 100000000 3)
          (filter #(< 0 (mod % 3)) (range 5 100000000 5))))
)


(time (+ (reduce + (range 3 1000 3))
         (reduce + (flatten (map drop-last (partition 3 (range 5 1000 5)))))))

(filter #(< 0 (mod % 3)) (range 5 1000 5))


;;          --             --               every 3rd of the numbers dividing 5
;;   5   10 15    20 25    30    35 40   ...
;; 3 6 9 12 15 18 21 24 27 30 33 36 39 42     
;;          --             --               every 5th of the numbers dividing 3

(time (count (* 1000 1000 1000)))

(reduce + (range (* 3 5) 1000 (* 3 5)))


(reduce + (range 101))

(defn range-sum [max]
  (* (+ max 1) (/ max 2)))

(range-sum 100)

(1 + 100) + (2 + 99) + (3 + 98) + . . . . + (50 + 51) = ?

(count '(3 6 9 12 15 18 21 24 27 30 33 36 39 42 45 48 51 54 57 60 63 66 69 72 75 78 81 84 87 90 93 96 99))
(99 96 93 90 87 84 81 78 75 72 69 66 63 60 57 54 51 48 45 42 39 36 33 30 27 24 21 18 15 12 9 6 3)
(reduce + (range 3 100 3))
(defn calc [max step] (* (+ max (- step 1) (/ 100 (* step 2)))))
(calc 100 3)

(/ (reduce + (map + (range 3 100 3) (reverse (range 3 100 3))))2)

(=
 (reduce + (range 5 105 5))
 (/ (reduce + (map + (range 5 105 5) (reverse (range 5 105 5))))2))

(first (reverse (range 5 100 5)))

(mod 105 5)



(defn range-sum 
  ([max] (* (+ max 1) (/ max 2)))
  ([max step] 
     (bigint (/ (+ max (* (- max (mod max step))
                       (bigint (/ max step)))) 2))))


(*  (/ 105 5) (- 105 (mod 105 5)))


(- 105 (mod 105 5))

(count '(3 6 9 12 15 18 21 24 27 30 33 36 39 42 45 48 51 54 57 60 63 66 69 72 75 78 81 84 87 90 93 96 99))

(3 6 9 12 15 18 21 24 27 30 33 36 39 42 45 48 51 54 57 60 63 66 69 72 75 78 81 84 87 90 93 96 99)

(99 96 93 90 87 84 81 78 75 72 69 66 63 60 57 54 51 48 45 42 39 36 33 30 27 24 21 18 15 12 9 6 3)

(+ (reduce + (take 16 (range 3 100 3)))
   (reduce + (take 16 (reverse (range 3 100 3))))
   51)

;; group-value
(- 100 (mod 100 3))
;; groups
(int (/ 100 3))
;; range-sum
(int (/ (+ 100 (* (- 100 (mod 100 3))
                  (int (/ 100 3)))) 2))
(reduce + (range 3 100 3))
(range-sum 100 3)

(range-sum 100 5)
(reduce + (range 5 105 5))

(/ 100 5)

(- (+ (range-sum 1000 3)
      (range-sum 1005 5)
      )
   (range-sum 1000 (* 3 5))
   1000
   1000
   )
(defn da-sum [max s1 s2]
  (- (+ (range-sum max s1)
      (range-sum (+ max s2) s2))
   (range-sum max (* s1 s2))
   max max))


(- (+ (range-sum 100000000 3)
      (range-sum 100000005 5)
      )
   (range-sum 100000000 (* 3 5))
   )

(= "2333333316666668" (str (da-sum 100000000 3 5)))

(str (da-sum (* 10000 10000 10000) 7 11))

(- 1277732511922987429116 (da-sum (* 10000 10000 10000) 757 809))
(- 110389610389889610389610 (da-sum (* 10000 10000 10000) 7 11))
(- 4530161696788274281 (da-sum (* 10000 10000 1000) 1597 3571))

(* 1597 3571)

(- (* 10000 10000 1000)  (mod (* 10000 10000 1000) 1597))


(for [x (range 3 1000 3) y (range 5 1000 5) :when ()])

(=
 (reduce + (filter #(or (zero? (mod % 3)) (zero? (mod % 5))) (range 1000)))
 (+ (reduce + (range 3 1000 3))
    (reduce + (filter #(< 0 (mod % 3)) (range 5 1000 5))))
 (- (+ (reduce + (range 3 1000 3))
       (reduce + (range 5 1000 5)))
    (reduce + (range 15 1000 15))))

(= (last (range 3 1000 3)) (- 1000 (mod 1000 3)))
(= (last (range 5 1000 5)) (- (- 1000 1) (mod (- 1000 1) 5)))
(= (last (range 3 1000 3)) (- (- 1000 1) (mod (- 1000 1) 3)))

(defn group-value [max step]
  (+ (- (- max 1) 
        (mod (- max 1) step))
     step))

(defn last-in-range [max step]
  (- (- max 1) 
        (mod (- max 1) step)))

(defn range-sum [max step]
  (let [x (dec max)
        last-in-range (- x (mod x step))]
    (* (+ last-in-range step)
       (/ (/ last-in-range step) 2))))

(- (+
    (range-sum 1000 3)
    (range-sum 1000 5))
   (range-sum 1000 15))

(defn da-sum [max a b]
  (- (+
    (range-sum max a)
    (range-sum max b))
   (range-sum max (* a b))))

(da-sum 1000 3 5)
(da-sum (* 10000 10000 10000) 7 11)

(= "110389610389889610389610"
   (str (da-sum (* 10000 10000 10000) 7 11)))
(= "1277732511922987429116"
   (str (da-sum (* 10000 10000 10000) 757 809)))
(= "4530161696788274281"
   (str (da-sum (* 10000 10000 1000) 1597 3571)))
(dec m)
(- m 1)

;; 233168 
(/ (reduce + (range 3 1000 3)) (group-value 1000 3))

(= (reduce + (range 3 1000 3))
   (* (group-value 1000 3)
      (/ (int (/ 999 3)) 2)))

(= (reduce + (range 5 1000 5))
   (* (group-value 1000 5)
      (/ (int (/ 995 5)) 2)))

(* (group-value 1000 3)
   (/ (int (/ 1000 3)) 2))





(= (reduce + (range 3 100 3))
 (range-sum 100 3))
