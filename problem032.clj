;;Write a function which duplicates each element of a sequence.

(let [__ (fn [s] (remove seq? (tree-seq seq? seq (map #(list % %) s))))]
  (every? true?
    [(= (__ [1 2 3]) '(1 1 2 2 3 3))
(= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))]
))

;#(interleave % %)

(defn flatten-once [s] (remove seq? (tree-seq seq? seq s)))

(flatten-once (map #(list % %) [[1 2] [3 4]]))
(flatten-once (map #(list % %) [:a :a :b :b]))
(flatten-once (map #(list % %) [1 2 3]))

((fn [s] (remove seq? (tree-seq seq? seq (map #(list % %) s)))) [[1 2] [3 4]])
