;;Write a function which generates the <a href="http://en.wikipedia.org/wiki/Transitive_closure">transitive closure</a> of a <a href="http://en.wikipedia.org/wiki/Binary_relation">binary relation</a>.  The relation will be represented as a set of 2 item vectors.

(let [__ 
      (fn T [c] 
        (let [t (#(into % (for [[a b] % [c d] % :when (= b c)] [a d])) c)]
          (if (= c t) c (T t))))]
  (every? true?
          [(let [divides #{[8 4] [9 3] [4 2] [27 9]}]
             (= (__ divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))
           (let [more-legs
                 #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
             (= (__ more-legs)
                #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
                  ["spider" "cat"] ["spider" "man"] ["spider" "snake"]}))
           (let [progeny
                 #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
             (= (__ progeny)
                #{["father" "son"] ["father" "grandson"]
                  ["uncle" "cousin"] ["son" "grandson"]}))]
          ))


(defn transitive [coll]
  (into coll (for [[a b] coll [c d] coll :when (= b c)] [a d])))

(defn trans [coll]
  (loop [c coll
         t (transitive c)]
    (if (= t c) 
      t
      (recur t (transitive t)))))

(defn tr [coll] 
  (loop [c coll]
      (if (= c (transitive c))
        c
        (recur (transitive c)))))

(defn tra [c] 
  (if (= c (transitive c))
    c
    (recur (transitive c))))

(defn tran [c] 
  (let [t (transitive c)]
    (if (= c t)
      c
      (recur t))))



(defn tran_ [c] 
  (let [t (#(into % (for [[a b] % [c d] % :when (= b c)] [a d])) c)]
    (if (= c t)
      c
      (recur t))))

(fn r [c] 
  (let [t (#(into % (for [[a b] % [c d] % :when (= b c)] [a d])) c)]
    (if (= c t)
      c
      (r t))))

(tr #{["cat" "man"] ["man" "snake"] ["spider" "cat"]})

(= #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}
   (transitive #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}))
(= (transitive #{["cat" "man"] ["man" "snake"] ["spider" "cat"]})
   (transitive
    (transitive #{["cat" "man"] ["man" "snake"] ["spider" "cat"]})))

(= (transitive
    (transitive #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}))
   (transitive
    (transitive
     (transitive #{["cat" "man"] ["man" "snake"] ["spider" "cat"]})))
   (trans #{["cat" "man"] ["man" "snake"] ["spider" "cat"]})
   (tr #{["cat" "man"] ["man" "snake"] ["spider" "cat"]})
   (tra #{["cat" "man"] ["man" "snake"] ["spider" "cat"]})
   (tran #{["cat" "man"] ["man" "snake"] ["spider" "cat"]})
   (tran_ #{["cat" "man"] ["man" "snake"] ["spider" "cat"]})
   ((fn r [c] 
  (let [t (#(into % (for [[a b] % [c d] % :when (= b c)] [a d])) c)]
    (if (= c t)
      c
      (r t)))) 
    #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}
    )
   )
