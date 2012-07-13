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

