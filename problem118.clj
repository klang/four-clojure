;;<p>Map is one of the core elements of a functional programming language. Given a function <code>f</code> and an input sequence <code>s</code>, return a lazy sequence of <code>(f x)</code> for each element <code>x</code> in <code>s</code>.

;;chouser:
(fn l [f [a & m]]
  (lazy-seq
   (cons (f a) (if m (l f m)))))
;; amazing tight use of deconstruction and standard value returned from if .. 


(let [__ (fn m [f n]
	   (lazy-seq
	    (if (empty? n)
	      ()
	      (cons (f (first n))
		    (m f (rest n))))))]
  (every? true?
	  [(= [3 4 5 6 7]
		(__ inc [2 3 4 5 6]))
	   (= (repeat 10 nil)
	      (__ (fn [_] nil) (range 10)))
	   (= [1000000 1000001]
		(->> (__ inc (range))
		     (drop (dec 1000000))
		     (take 2)))]
	  ))


(defn m [f s] (cons (f (first s)) (m f (rest s))))

((fn m [f s] (cons (f (first s)) (m f (rest s)))) inc [2 3 4 5 6])

(cons (inc (first [2 3 4 5 6])) (map inc (rest [2 3 4 5 6])))

