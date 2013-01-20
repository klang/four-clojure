;;	 Given a mathematical formula in prefix notation, return a function that calculates
the value of the formula.
The formula can contain nested calculations using the four basic
mathematical operators, numeric constants, and symbols representing variables.
The returned function has to accept a single parameter containing the map
of variable names to their values.


(let [__ "Solution here"]
  (every? true?
          [(= 2 ((__ '(/ a b))
                 '{b 8 a 16}))
           (= 8 ((__ '(+ a b 2))
                 '{a 2 b 4}))
           (= [6 0 -4]
              (map (__ '(* (+ 2 a)
                           (- 10 b)))
                           '[{a 1 b 8}
                             {b 5 a -2}
                             {a 2 b 11}]))
           (= 1 ((__ '(/ (+ x 2)
                         (* 3 (+ y 1))))1
                         '{x 4 y 1}))
                         ]
          ))


(def p '{b 8 a 16})
(p 'a)
((fn [p] (/ (p 'a) (p 'b))) '{b 8 a 16})

((fn [p] (let [a (p 'a) b (p 'b)] (/ a b))) '{b 8 a 16})

((#(fn [p] (let [a (p 'a) b (p 'b)] %)) '(/ a b)) '{b 8 a 16})


((eval `(let [~@(mapcat (fn [[k v]] [k `'~v]) %2)] ~%)) '(/ a b)) '{b 8 a 16}

(defn contextual-eval [ctx expr]
  (eval
   `(let [~@(mapcat (fn [[k v]] [k `'~v]) ctx)]
      ~expr)))


((#(fn [p] (let [a (p 'a) b (p 'b)] %)) '(/ a b)) '{b 8 a 16})

(contextual-eval {'a 1, 'b 2} '(+ a b))
(let [x 9, y '(- x)]
(println `y)
(println ``y)
(println ``~y)
(println ``~~y)
(contextual-eval {'x 36} ``~~y))


(def x 5)

(def lst '(a b c))

`(fred x ~x lst ~@lst 7 8 :nine)
    (user/fred user/x 5 user/lst a b c 7 8 :nine)

'(/ a b)

'/
'a
( (__ '(/ a b)) '{b 8 a 16})

[@(1 2 3)]

((__ '(+ a b 2)) '{a 2 b 4})
((fn [p] (+ (p 'a) (p 'b) 2)) '{b 2 a 4})