;;<p>Map is one of the core elements of a functional programming language. Given a function <code>f</code> and an input sequence <code>s</code>, return a lazy sequence of <code>(f x)</code> for each element <code>x</code> in <code>s</code>.

(let [__ (fn m [f x] (cons (f (first x)) (lazy-seq m f (rest x))))]
  (every? true?
          [(= [3 4 5 6 7]
              (__ inc [2 3 4 5 6]))
           (= (repeat 10 nil)
              (__ (fn [_] nil) (range 10)))
           (= [1000000 1000001]
              (->> (__ inc (range))
                   (drop (dec 1000000))
                   (take 2)))]
          ))

 (inc (first [3 4 5 6 7]))

(rest [3 4 5 6 7])

((fn m [f x] (cons (f (first x)) (lazy-seq m f (rest x)))) inc [2 3 4 5 6])



(lazy-seq  )
;; problem 062 (iterate)
;;(fn i [f x] (cons x (lazy-seq (i f (f x)))))
;;#(reductions(fn[x _](% x))%2(range))

;; (fn i [f x] (cons x (lazy-seq (i f (f x)))))

((fn m [f x] (cons (f (first x)) (lazy-seq m f (rest x)))) inc [2 3 4 5 6])


(def x [2 3 4 5 6])
(inc (first x))
(rest x)

( (fn m [f x]
    (cons (f (first x))
	  (lazy-seq (m f (rest x)))))
  inc [2 3 4 5 6])
