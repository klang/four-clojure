;;Write a higher-order function which flips the order of the arguments of an input function.
;; (fn [f] #(f %2 %))
;; #(fn[a b](% b a))
(let [__ #(fn[a b](% b a))]
  (every? true?
          [(= 3 ((__ nth) 2 [1 2 3 4 5]))
           (= true ((__ >) 7 8))
           (= 4 ((__ quot) 2 8))
           (= [1 2 3] ((__ take) [1 2 3 4 5] 3))]
          ))

((#(fn [a b] (% b a)) nth) 2 [1 2 3 4 5])