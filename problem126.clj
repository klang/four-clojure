;;Enter a value which satisfies the following:

(let [__ "Solution here"]
  (every? true?
          [(let [x __]
             (and (= (class x) x) x))]
          ))

(and (= (class nil) nil) nil)

;; where class of the expression is the same as the expression
;; --> nil

;; an expression that evaluates to true
;; --> (true? nil) => false

(let [x nil] (and (= (class x) x) x))
(let [x false] (and (= (class x) x) x))
(let [x true] (and (= (class x) x) x))
(let [x (java.lang.Boolean. "true")] (and (= (class x) x) x))
(let [x (java.lang.Boolean. "false")] (and (= (class x) x) x))
(let [x #()] (and (= (class x) x) x))
(let [x class] (and (= (class x) x) x))
(let [x []] (and (= (class x) x) x))
(let [x ()] (and (= (class x) x) x))

; .. (and true Class) is considered true so maybe..
(let [x java.lang.Class] (and (= (class x) x) x))
