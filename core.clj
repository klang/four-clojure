(ns four-clojure.core)

;;23
;;Write a function which reverses a sequence.

(let [__ #(into '() %)]
	(= (__ [1 2 3 4 5]) [5 4 3 2 1])
	(= (__ (sorted-set 5 7 2 7)) '(7 5 2))
	(= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]))
;; into ()


;;#32
;;Write a function which duplicates each element of a sequence.

(let [__ "Solution here"]
	(= (__ [1 2 3]) '(1 1 2 2 3 3))
	(= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
	(= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
	(= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
	)
(into [] (map #(vector % %) [1 2 3]))


