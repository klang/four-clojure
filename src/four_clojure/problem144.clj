;;Write an oscillating iterate: a function that takes an initial value and a variable number of functions. It should return a lazy sequence of the functions applied to the value in order, restarting from the first function after it hits the end.

;; chouser: #(reductions (fn [x f] (f x)) % (cycle %&))

(let [__ (fn o [x f & fs] (cons x (lazy-seq (apply o (f x) (concat fs [f])))))]
  (every? true?
          [(= (take 3 (__ 3.14 int double)) [3.14 3 3.0])
           (= (take 5 (__ 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7])
           (= (take 12 (__ 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3])
           ]
          ))

;; when you want to use ~@ slice, apply is probably what you want
(defn oscilate 
  [x f & fs] (cons x (lazy-seq (apply oscilate (f x) (concat fs [f])))))

(comment 
  ;; this works .. for 5 functions
  (defn oscilate
    [x f1 f2 f3 f4 f5]
    (cons x (lazy-seq (oscilate (f1 x) f2 f3 f4 f5 f1))))

  (= (take 12 (oscilate 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3])
  [(-> 0) (-> 0 inc) (-> 0 inc dec) (-> 0 inc dec inc) (-> 0 inc dec inc dec) (-> 0 inc dec inc dec inc) (-> 0 inc dec inc dec inc inc)]
  )


