;;
<p>
Given a set of sets, create a function which returns <code>true</code> 
if no two of those sets have any elements in common<sup>1</sup> and <code>false</code> otherwise. 
Some of the test cases are a bit tricky, so pay a little more attention to them. 
</p>

<p>
<sup>1</sup>Such sets are usually called <i>pairwise disjoint</i> or <i>mutually disjoint</i>.
</p>
;; into set remove
#(into (set (remove %2 %)) (remove % %2))
((comp set keep) #{:a :b :c :d :e} #{:a :b :c :d})

(def __ 
  #(empty? (for [a % b % :when (and (not= a b) (not-empty ((comp set keep) a b)))] false)))

( __ #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}}  )

( __ #{#{:a :b :c :d :e} #{:a :b :c :d} #{:a :b :c} #{:a :b} #{:a}}  )

( __
  #{#{(#(-> *)) + (quote mapcat) #_ nil}
    #{'+ '* mapcat (comment mapcat)}
    #{(do) set contains? nil?}
    #{, , , #_, , empty?}}
  )

(every? true? (map #(contains? % nil) #{#{nil :a} #{nil :b}}))

(defn share-nil? [& m] (every? true? (map (fn [x] (contains? x nil)) m)))

(share-nil? #{nil :a} #{nil :b})

(def __ 
  #(empty? (for [a % b % :when
                 (and (not= a b)
                      (not (every? true? (map (fn [x] (contains? x nil)) [a b])))
                      (not-empty ((comp set keep) a b)))] false)))

(some true? (map share-nil?
                 #{#{(#(-> *)) + (quote mapcat) #_ nil}
                   #{'+ '* mapcat (comment mapcat)}
                   #{(do) set contains? nil?}
                   #{, , , #_, , empty?}}))

(let [__
      #(empty? (for [a % b %
                     :when
                     (and (not= a b)
                          (not-empty ((comp set keep) a b)))] false))
      ]
  #_(every? true?)
  [(= (__ #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
      true)
   (= (__ #{#{:a :b :c :d :e}
            #{:a :b :c :d}
            #{:a :b :c}
            #{:a :b}
            #{:a}})
      false)
   (= (__ #{#{[1 2 3] [4 5]}
            #{[1 2] [3 4 5]}
            #{[1] [2] 3 4 5}
            #{1 2 [3 4] [5]}})
      true)
   (= (__ #{#{'a 'b}
            #{'c 'd 'e}
            #{'f 'g 'h 'i}
            #{''a ''c ''f}})
      true)
   (= (__ #{#{'(:x :y :z) '(:x :y) '(:z) '()}
            #{#{:x :y :z} #{:x :y} #{:z} #{}}
            #{'[:x :y :z] [:x :y] [:z] [] {}}})
      false)
   (= (__ #{#{(= "true") false}
            #{:yes :no}
            #{(class 1) 0}
            #{(symbol "true") 'false}
            #{(keyword "yes") ::no}
            #{(class '1) (int \0)}})
      false)
   (= (__ #{#{distinct?}
            #{#(-> %) #(-> %)}
            #{#(-> %) #(-> %) #(-> %)}
            #{#(-> %) #(-> %) #(-> %)}})
      true)
   (= (__ #{#{(#(-> *)) + (quote mapcat) #_ nil}
            #{'+ '* mapcat (comment mapcat)}
            #{(do) set contains? nil?}
            #{, , , #_, , empty?}})
      false)]
          )

