;;Sequential destructuring allows you to bind symbols to parts of sequential things (vectors, lists, seqs, etc.): <a href="http://clojure.org/special_forms#Special Forms--(let [bindings* ] exprs*)">(let [bindings* ] exprs*)</a>

Complete the bindings so all let-parts evaluate to 3.


(every? true?
	[(= 3
	    (let [[x y] [+ (range 3)]] (apply x y))
	    (let [[[x y] b] [[+ 1] 2]] (x y b))
	    (let [[x y] [inc 2]] (x y)))]
	)