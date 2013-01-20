;;Write a function which takes a variable number of booleans.  Your function should return true if some of the parameters are true, but not all of the parameters are true.  Otherwise your function should return false.

(some true? [true false false true])
(every? true? [true])
(fn [& s] (cond (some true? s) (not (every? true? s)) :else false))
(fn [& s] (if (some true? s) (not (every? true? s)) false))
#(if (some true? %&) (not (every? true? %&)) false)
#(if (some true? %&) (not-every? true? %&) false)

;; not=
(let [__ #(if (some true? %&) (not-every? true? %&) false)]
  (every? true?
          [(= false (__ false false))
           (= true (__ true false))
           (= false (__ true))
           (= true (__ false true false))
           (= false (__ true true true))
           (= true (__ true true true false))]
          ))

