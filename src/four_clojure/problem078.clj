;;Reimplement the function described in <a href="76"> "Intro to Trampoline"</a>.

;; trampoline with shorter names
(fn t
  ([f] (let [r (f)] (if (fn? r) (recur r) r)))
  ([f & a] (t #(apply f a))))

;; and with several function constructions
(fn t
  ([f] (if (fn? (f)) (recur (f)) (f)))
  ([f & a] (t #(apply f a))))


;;cgrand:  #(if (fn? %) (recur (apply % %&) ()) %)
;;chouser: (fn t [f & x] (if (fn? f) (t (apply f x)) f))

(let [__ (fn t
  ([f] (if (fn? (f)) (recur (f)) (f)))
  ([f & a] (t #(apply f a))))]
  (every? true?
          [(= (letfn [(triple [x] #(sub-two (* 3 x)))
                      (sub-two [x] #(stop?(- x 2)))
                      (stop? [x] (if (> x 50) x #(triple x)))]
                (__ triple 2))
              82)
           (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
                      (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
                (map (partial __ my-even?) (range 6)))
              [true false true false true false])]
          ))

