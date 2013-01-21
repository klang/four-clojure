;;Write a function which returns a sequence of lists of x items each.  Lists of less than x items should not be returned.

(defn p
  [n c]
  (lazy-seq
   (let [a (take n c)]
     (when (= n (count a))
       (cons a (p n (drop n c)))))))


;; #(take-nth % (apply map list (take % (iterate next %2))))

(let [__
      (fn p [n c]
	(lazy-seq
	 (let [a (take n c)]
	   (when (= n (count a))
	     (cons a (p n (drop n c)))))))
      ]
  (every? true?
	  [(= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
	   (= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
	   (= (__ 3 (range 8)) '((0 1 2) (3 4 5)))]
	  ))


(first (lazy-seq (take 3 (range 9)) (drop 3 (range 9))))

(partition)

(loop [t (range 9) r '()]
  (if t (take 3 (range 9))))


(defn p
  [n c]
  (lazy-seq
   (let [a (take n c)]
     (when (= n (count a))
       (cons a (p n (drop n c)))))))


