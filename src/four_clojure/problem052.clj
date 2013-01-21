;;Let bindings and function parameter lists support destructuring.

(let [__ '(c e)]
  (every? true?
    [(= [2 4] (let [[a b c d e f g] (range)] __))]
    ))

(let [__ [c e]]
  
  (let [[a b c d e f g] (range)] __)
    )

[(= [2 4] (let [[a b c d e f g] (range)] [c e]))]