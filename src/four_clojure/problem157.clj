;;Transform a sequence into a sequence of pairs containing the original elements along with their index.

;;#(map vector % (range))
;;#(map list % (range))  ---> damn!! vector and list works in the exact same way for the equalities

(let [__ #(map vector % (range))]
  #_(every? true?)
  [(= (__ [:a :b :c]) [[:a 0] [:b 1] [:c 2]])
   (= (__ [0 1 3]) '((0 0) (1 1) (3 2)))
   (= (__ [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]])]
          )

(#(map ) [:a :b :c])

[[:a 0] [:b 1] [:c 2]]

(map #(vector % %2) [[:foo] {:bar :baz}] (range))

(#(map (fn [x i] (vector x i)) % (range)) [:a :b :c])

(#(map (fn [x i] (vector x i)) % (range)) [:a :b :c])

(#(map vector % (iterate inc 0)) [:a :b :c])
(#(map vector % (range)) [:a :b :c])
(#(map vector % (range)) [0 1 3])

(=
 [[[:foo] 0] [{:bar :baz} 1]]
 (#(map vector % (range)) [[:foo] {:bar :baz}])
 (#(map list % (range)) [[:foo] {:bar :baz}]))

