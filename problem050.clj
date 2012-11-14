;;Write a function which takes a sequence consisting of items with different types and splits them up into a set of homogeneous sub-sequences. The internal order of each sub-sequence should be maintained, but the sub-sequences themselves can be returned in any order (this is why 'set' is used in the test cases).

;; this works .. but eval can not be used
;;#(vals(eval`(merge-with concat ~@(for[x %]{(type x)[x]}))))

;; ---damnit!!  #(vals (group-by type %))
(let [__ #(vals(reduce(partial merge-with concat)(for[x %]{(type x)[x]})))]
  (every? true?
	  [(= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
	   (= (set (__ [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
	   (= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})])
          )



(hash-map (type 1))

(->> [1 :a 2 :b 3 :c]
     (map #(hash-map (type %) %))
     
     (into #{})
     )

(apply #(merge-with (comp concat vector) %))

(merge-with + {:a 1} {:a 2})
(merge-with (comp concat vector) `~@'({:a 1} {:b 1} {:a 2} {:b 2} {:a 3} {:b 3}))


(reduce  '({:a 1} {:b 1} {:a 2} {:b 2} {:a 3} {:b 3}))

(=
 (set (vals (merge-with concat {:a [4]} {:b [1]} {:a [5]} {:b [2]} {:a [6]} {:b [3]} )))
 #{[1 2 3] [4 5 6]})


(merge-with (comp concat vector) (map #(hash-map (type %) %)))

(concat (vector 1) (vector 2))

`[~@'(1 2 3)]

(set (vals (eval `(merge-with concat ~@(for [x [1 :a 2 :b 3 :c]] {(type x) [x]})))))

(set (vals ( (fn [c] `(merge-with concat ~@(for [x c] {(type x) [x]})))
		    [1 :a 2 :b 3 :c]
		    )))


(defn foo [c]
  (vals(eval`(merge-with concat ~@(for[x c]{(type x)[x]})))))

(set (foo [1 :a 2 :b 3 :c]))

(set (#(vals(eval`(merge-with concat ~@(for[x %]{(type x)[x]})))) [1 :a 2 :b 3 :c]))


(reduce (partial merge-with concat) (for[x [1 :a 2 :b 3 :c]]{(type x)[x]}))






(apply + `(100 ~@'(1 2 3 4 5) 200))

(= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})


(->> [1 :a 2 :b 3 :c]
     (map #(hash-map (type %) [%]))
     (reduce #(merge-with concat %))
     )


()

(set (#(map last (partition-by type %)) [1 :a 2 :b 3 :c]))
(set (#(map last (partition-by identity %)) [1 :a 2 :b 3 :c]))

(type 1)

(partition-by type [1 :a 2 :b 3 :c])