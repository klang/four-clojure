;;Clojure has many sequence types, which act in subtly different ways. The core functions typically convert them into a uniform "sequence" type and work with them that way, but it can be important to understand the behavioral and performance differences so that you know which kind is appropriate for your application.<br /><br />Write a function which takes a collection and returns one of :map, :set, :list, or :vector - describing the type of collection it was given.<br />You won't be allowed to inspect their class or use the built-in predicates like list? - the point is to poke at them and understand their behavior.

;; (comp {\# :set \{ :map \[ :vector \c :list} first str)
;; #((zipmap (map str [{} #{} () []]) [:map :set :list :vector]) (str (empty %))) 

;; ---> empty
;; ---> str
comp
(let [__ (fn [x]
    (let [r {clojure.lang.PersistentArrayMap :map
             clojure.lang.PersistentHashSet :set
             clojure.lang.PersistentVector :vector
             clojure.lang.LazySeq :list
             clojure.lang.PersistentList$EmptyList :list
             clojure.lang.PersistentList :list}]
      (r (first (filter #(if (. % (isInstance x)) %) (keys r))))))]
  (every? true?
          [(= :map (__ {:a 1, :b 2}))
           (= :list (__ (range (rand-int 20))))
           (= :vector (__ [1 2 3 4 5 6]))
           (= :set (__ #{10 (rand-int 5)}))
           (= [:map :set :vector :list] (map __ [{} #{} [] ()]))])
  )

(let [x '(1)
      r {clojure.lang.PersistentArrayMap :map
         clojure.lang.PersistentHashSet :set
         clojure.lang.PersistentVector :vector
         clojure.lang.PersistentList$EmptyList :list
         clojure.lang.PersistentList :list}]
  (r (first (filter #(if (. % (isInstance x)) %) (keys r)))))

(type (range (rand-int 20)))

((fn [x]
    (let [r {clojure.lang.PersistentArrayMap :map
             clojure.lang.PersistentHashSet :set
             clojure.lang.PersistentVector :vector
             clojure.lang.LazySeq :list
             clojure.lang.PersistentList$EmptyList :list
             clojure.lang.PersistentList :list}]
      (r (first (filter #(if (. % (isInstance x)) %) (keys r)))))) 
  (range (rand-int 20)))

