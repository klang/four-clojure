;;Write an oscillating iterate: a function that takes an initial value and a variable number of functions. It should return a lazy sequence of the functions applied to the value in order, restarting from the first function after it hits the end.

(let [__ "Solution here"]
  (every? true?
          [(= (take 3 (__ 3.14 int double)) [3.14 3 3.0])
           (= (take 5 (__ 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7])
           (= (take 12 (__ 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3])
           ]
          ))

(iterate  )

(defn foo [x f & fs]
  {:x x :f f :fs fs :first (first fs) :rest (rest fs) :continuation `(~@fs ~f)})

(foo 1 2 3 4 5)

(defn oscilate
  [x f & fs]
  ;;{:first x :next (f x) :rest `(~@fs ~f)  :f (first fs) :fs `(~@(rest fs) ~f)}
  {:x (f x) :f (first fs) :fs `(~@(rest fs) ~f)}
  #_(cons x (lazy-seq (oscilate (f x) (first fs) `(~@(rest fs) ~f))))

  )


(cons 11 (range 1 10))
(conj (range 1 10) 11)
(cat (range 1 10) 11)

(take 12 (oscilate 0 inc dec inc dec inc))

(cons (rest [1 2 3]) (first [1 2 3]))

(conj (vec (rest '(1 2 3))) (first '(1 2 3)) )


(defn iterate
  "Returns a lazy sequence of x, (f x), (f (f x)) etc. f must be free of side-effects"
  {:added "1.0"
   :static true}
  [f x] (cons x (lazy-seq (iterate f (f x)))))
