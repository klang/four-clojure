;;Write a function which separates the items of a sequence by an arbitrary value.

(let [__ #(drop 1 (mapcat list (repeat %) %2))]
  (every? true?
    [(= (__ 0 [1 2 3]) [1 0 2 0 3])
     (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
     (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])]
    ))

(mapcat list [:a :b :c :d] (repeat :z) )
#(mapcat list (repeat %) %2 )

(drop 1 (mapcat list (repeat 0)  [1 2 3] ))

#(drop 1 (mapcat list (repeat %) %2))
#(rest (mapcat list (repeat %) %2))