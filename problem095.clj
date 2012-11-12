;;Write a predicate which checks whether or not a given sequence represents a <a href="http://en.wikipedia.org/wiki/Binary_tree">binary tree</a>.  Each node in the tree must have a value, a left child, and a right child.

(fn f [t]
  (or (nil? t)
    (and (coll? t) (= 3 (count t))
      (every? f (next t)))))

(fn f [t]
  (if (coll? t)
    (let [[_ a b] t]
      (and (= 3 (count t)) (f a) (f b)))
    (nil? t)))

(let [__ (fn t [n] (cond
		    (and
		     (coll? n)
		     (= 3 (count n))
		     (or (nil? (nth n 1)) (t (nth n 1)))
		     (or (nil? (nth n 2)) (t (nth n 2))))
		    true
		    :else
		    false))]
  (every? true?
	  [(= (__ '(:a (:b nil nil) nil))
	      true)
	   (= (__ '(:a (:b nil nil)))
	      false)
	   (= (__ [1 nil [2 [3 nil nil] [4 nil nil]]])
	      true)
	   (= (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]])
	      false)
	   (= (__ [1 [2 [3 [4 nil nil] nil] nil] nil])
	      true)
	   (= (__ [1 [2 [3 [4 false nil] nil] nil] nil])
	      false)
	   (= (__ '(:a nil ()))
	      false)
	      ]
	  ))

(defn tree [t] (cond
		(and
		 (coll? t)
		 (= 3 (count t))
		 (or (nil? (nth t 1)) (tree (nth t 1)))
		 (or (nil? (nth t 2)) (tree (nth t 2))))
		true
		:else
		false))





(coll? [4 nil nil])
(coll? '(4 nil nil))
(tree '(:a (:b nil nil) nil))
(tree '(:a (:b nil nil)))
(tree [1 [2 [3 [4 false nil] nil] nil] nil])
(tree [1 [2 [3 [4 nil nil] nil] nil] nil])
(seq? nil)

(nth '(:a :b :c) 2)

(third )

(defn tree [[v l r]] (or (and (or (number? v) (keyword? v)) (tree l) (tree r))
			 (nil? l)
			 (nil? r)))
(defn __ [& t] (tree t))


