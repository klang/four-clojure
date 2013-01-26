;;Write a function which generates the <a href="http://en.wikipedia.org/wiki/Power_set">power set</a> of a given set.  The power set of a set x is the set of all subsets of x, including the empty set and x itself.

;; amalloy
(fn [c]
  (reduce #(into % (for [x %]
                     (conj x %2)))
          #{#{}}
          c))

;; chouser
#((fn f [[a & s :as q]]
    (if q
      (into (f s) (for [i (f s)] (conj i a)))
      #{#{}}))
  (seq %))

(let [__ 
(fn P [S]
  (if (empty? S) #{#{}}
      (let [e (first S) 
            T (P (disj S e))] 
        (into T (map #(conj % e) T)))))]
  (every? true?
          [(= (__ #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})
           (= (__ #{}) #{#{}})
           (= (__ #{1 2 3})
              #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})
           (= (count (__ (into #{} (range 10)))) 1024)]
          ))

(defn F [e S] 
  (into S (map #(conj % e) S)))

(defn P [S]
  (if (empty? S) #{#{}}
      (into (P (disj S (first S))) (F (first S) (P (disj S (first S)))))))

(fn P [S]
  (if (empty? S) #{#{}}
      (let [e (first S) 
            p (P (disj S e))] 
        (into p (F e p)))))

(defn P [S]
  (if (empty? S) #{#{}}
      (let [e (first S) 
            p (P (disj S e))] 
        (into p (into p (map #(conj % e) p))))))

(defn P [S]
  (if (empty? S) #{#{}}
      (let [e (first S) 
            T (P (disj S e))] 
        (into T (map #(conj % e) T)))))

;; (#(set      (for [a % b %2] [a b])) #{1 2 3} #{4 5})
;; (#(into #{} (for [a % b %2] [a b])) #{1 2 3} #{4 5})

;; 123
;; 000 => #{}
;; 001 => #{3}
;; 010 => #{2}
;; 011 => #{2 3}
;; 100 => #{1}
;; 101 => #{1 3}
;; 110 => #{1 2}
;; 111 => #{1 2 3}

(F 3 #{#{} #{1} #{2} #{1 2}})

(comment
  (clojure.set/union #{1 2 3} #{5 6 7})
  (into #{1 2 3} #{5 6 7})
  (disj #{1 2 3} 2)
  (into #{#{} #{1} #{2} #{1 2}} (F 3 #{#{} #{1} #{2} #{1 2}}))
  (set (concat (F 1 #{#{}}) (F 2 #{#{}}) (F 3 #{#{}})))  
  (into #{#{}} (F 1 #{#{}})))

(comment
  (F 1 #{#{}})
  (F 2 #{#{} #{1}})
  (F 3 (F 2 #{#{} #{1}}))
  (F 3 (F 2 (F 1 #{#{}})))

  (->>  #{#{}} (F 1) (F 2) (F 3))

  (take 1 `(->>  #{#{}}
                 ~@(map #(partial F %) #{1 2 3}))))


(and
 (= (P #{}) #{#{}})
 (= (P #{1 2}) #{#{}#{1} #{2} #{1 2}})
 )



