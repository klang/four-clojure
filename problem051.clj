;;Here is an example of some more sophisticated destructuring.

(let [__ "Solution here"]
  (every? true?
    [(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))]
    ))

[(= [1 2 [3 4 5] [1 2 3 4 5]]
    (let [[a b & c :as d] [1 2 3 4 5]] [a b c d]))]