;;Write a function which reverses the interleave process into x number of subsequences.

(let [__ "Solution here"]
  (every? true?
          [(= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
           (= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
           (= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))]
          ))

(interleave '(0 3 6) '(1 4 7) '(2 5 8) )

(for [x (range 2) :let [y [1 2 3 4 5 6]]] [x y])

(for [x (range 5) y (range 10)] {x y})
(map )
[ (filter #(= 0 (mod % 3)) (drop 0 (range 9)))
  (filter #(= 0 (mod % 3)) (drop 1 (range 9)))
  (filter #(= 0 (mod % 1)) (drop 2 (range 9)))]