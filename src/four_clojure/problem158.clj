;;Write a function that accepts a curried function of unknown arity <i>n</i>.  Return an equivalent function of <i>n</i> arguments.
<br/>
You may wish to read <a href="http://en.wikipedia.org/wiki/Currying">this</a>.

(let [__ "Solution here"]
  (every? true?
          [(= 10 ((__ (fn [a]
                        (fn [b]
                          (fn [c]
                            (fn [d]
                              (+ a b c d))))))
                              1 2 3 4))
           (= 24 ((__ (fn [a]
                        (fn [b]
                          (fn [c]
                            (fn [d]
                              (* a b c d))))))
                              1 2 3 4))
           (= 25 ((__ (fn [a]
                        (fn [b]
                          (* a b))))
                          5 5))
                          ]
          ))

(
 (
  (
   (
    (fn [a] (fn [b] (fn [c] (fn [d] (* a b c d))))) 
    1)
   2)
  3)
 4)


(fn? (fn [a] (fn [b] (fn [c] (fn [d] (* a b c d))))))
(fn? ((fn [a] (fn [b] (fn [c] (fn [d] (* a b c d))))) 1))
(fn? (((fn [a] (fn [b] (fn [c] (fn [d] (* a b c d))))) 1)2))
(fn? ((((fn [a] (fn [b] (fn [c] (fn [d] (* a b c d))))) 1)2)3))
(fn? (((((fn [a] (fn [b] (fn [c] (fn [d] (* a b c d))))) 1)2)3)4))


(defn de-curry [f & args]
  ()
  )

(defn r [f a & b]
  (if (fn? (f a))
    (r (f a) b))
  {:ff (fn? (f a))
   :f f
   :a a
   :b b}
  )

(r (fn [a] (fn [b] (* a b))) 5 5)
(r :f 1 2 3 4 5)

(f h)

(((fn [a] (fn [b] (* a b))) 5) 5)
(#(((fn [a] (fn [b] (* a b))) %2) %1) 5 5)

((fn [& m] (apply (fn [a] (fn [b] (* a b))) m)) 5 5)


((__ (fn [a] (fn [b] (* a b))))  5 5)

(when-let)

