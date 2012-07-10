;;Write a function which takes two sequences and returns the first item from each, then the second item from each, then the third, etc.

(let [__ #(flatten (into () (zipmap % %2)))]
  (every? true?
    [(= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
     (= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
     (= (__ [1 2 3 4] [5]) [1 5])
     (= (__ [30 20] [25 15]) [30 25 20 15])]
    ))

(flatten (into () (zipmap [1 2 3] [:a :b :c])))
(flatten (into () (zipmap [1 2 3 4] [5])))

;; mapcat list

(flatten (map list [1 2 3] [:a :b :c]))

(apply concat (map list [1 2 3] [:a :b :c]))
(mapcat list [1 2 3] [:a :b :c])