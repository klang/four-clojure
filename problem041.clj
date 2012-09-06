;;Write a function which drops every Nth item from a sequence.

;; #(keep-indexed (fn [i x] (when (< 0 (mod (+ 1 i) %2)) x)) %)

(let [__ (fn[c s]
	   (filter (comp not nil?)
		   (map #(if (< 0 (mod (inc %2) s)) %) c (range))))]
  (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
  (= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
  (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])
  )

(#(map ) [1 2 3 4 5 6 7 8] 3)

(map #(vector % %2) [1 2 3 4 5 6 7 8] (iterate inc 1))

(filter (comp not nil?)
	(map #(if (zero? (mod %2 3)) nil %) [1 2 3 4 5 6 7 8] (iterate inc 1)))

(fn[c s]
  (filter (comp not nil?)
	  (map #(if (zero? (mod %2 s)) nil %) c (iterate inc 1))))


(filter (comp not nil?)
	(map #(if (< 0 (mod %2 3)) %) [1 2 3 4 5 6 7 8] (iterate inc 1)))

(filter (comp not nil?)
	(map #(if (< 0 (mod (inc %2) 3)) %) [1 2 3 4 5 6 7 8] (range)))

