;;Write a function which flattens a sequence.

(let [__ #(filter (complement sequential?) (rest (tree-seq sequential? seq %)))]
  (every? true?
    [(= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
     (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
     (= (__ '((((:a))))) '(:a))]
    ))

;; (fn f [x] (if (coll? x) (mapcat f x) [x]))

(defn flatten-once [s] (remove seq? (tree-seq seq? seq s)))

   