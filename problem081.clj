;;Write a function which returns the intersection of two sets.  The intersection is the sub-set of items that each set has in common.

(let [__ #(set(for[a % :when(%2 a)]a))]
  (every? true?
          [(= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3})
           (= (__ #{0 1 2} #{3 4 5}) #{})
           (= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})]
          ))

;; #(set (filter % %2))
;; (comp set keep)

(set (for [a #{0 1 2 3} :when (contains? #{2 3 4 5} a) ] a))
#(set (for [a % :when (contains? %2 a)] a))

