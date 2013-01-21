;;A function f defined on a domain D induces an <a href="http://en.wikipedia.org/wiki/Equivalence_relation">equivalence relation</a> on D, as follows: a is equivalent to b with respect to f if and only if (f a) is equal to (f b).  Write a function with arguments f and D that computes the <a href="http://en.wikipedia.org/wiki/Equivalence_class">equivalence classes</a> of D with respect to f.

(map set (vals (group-by #(* % %) #{-2 -1 0 1 2})))

(comp map set vals group-by)

(let [__ #(set (map set (vals (group-by % %2))))]
  (every? true?
	  [(= (__ #(* % %) #{-2 -1 0 1 2})
	      #{#{0} #{1 -1} #{2 -2}})
	   (= (__ #(rem % 3) #{0 1 2 3 4 5 })
	      #{#{0 3} #{1 4} #{2 5}})
	   (= (__ identity #{0 1 2 3 4})
	      #{#{0} #{1} #{2} #{3} #{4}})
	   (= (__ (constantly true) #{0 1 2 3 4})
	      #{#{0 1 2 3 4}})
	      ]
	  ))
(#(set (map set (vals (group-by % %2))))
 #(* % %) #{-2 -1 0 1 2}
 )

(#(->> %2 (group-by %) vals (map set) set) #(* % %) #{-2 -1 0 1 2} )
#(->> (group-by %1 %2) vals (map set) set)
#(set (map set (vals (group-by % %2))))

(#(set (map set (vals (group-by % %2)))) #(* % %) #{-2 -1 0 1 2} )





(zap #(* % %) #{-2 -1 0 1 2})

((fn [f v] (zipmap v (map f v))) #(* % %) #{-2 -1 0 1 2})

((fn [f v] (map #(conj #{} (f %)) v)) #(* % %) #{-2 -1 0 1 2})

(merge-with  {4 -2} {4 2})



(merge-with conj {4 #{-2}} {4 #{2}})
(merge-with conj {4 #{}} {4 2})
(merge-with conj {4 #{2}} {4 -2})

(f [f v] (map #(conj #{} (f %)) v))
( #(* % %) #{-2 -1 0 1 2})
(hash-map)
(apply + )

(memoize)

(set (vals {4 #{2 -2} 0 #{0} 1 #{1 -1}}))

(defn memoize
  "Returns a memoized version of a referentially transparent function. The
  memoized version of the function keeps a cache of the mapping from arguments
  to results and, when calls with the same arguments are repeated often, has
  higher performance at the expense of higher memory use."
  {:added "1.0"
   :static true}
  [f]
  (let [mem (atom {})]
    (fn [& args]
      (if-let [e (find @mem args)]
        (val e)
        (let [ret (apply f args)]
          (swap! mem assoc args ret)
          ret)))))
