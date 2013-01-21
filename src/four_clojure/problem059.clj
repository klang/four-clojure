;;Take a set of functions and return a new function that takes a variable number of arguments and returns a sequence containing the result of applying each function left-to-right to the argument list.

(let [__ (fn
           ([f g] (fn ([x] [(f x) (g x)])))
           ([f g h] 
              (fn
                ([x] [(f x) (g x) (h x)])
                ([x y z & args] [(apply f x y z args) (apply g x y z args) (apply h x y z args)])))
           )]
  (every? true?
          [(= [21 6 1] ((__ + max min) 2 3 5 1 6 4))
           (= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello"))
           (= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))]
          ))

;; (fn [& s] #(for [f s] (apply f %&)))

(defn juxt* 
  ([f g] (fn ([x] [(f x) (g x)])))
  ([f g h] 
     (fn
       ([x] [(f x) (g x) (h x)])
       ([x y z & args] [(apply f x y z args) (apply g x y z args) (apply h x y z args)])))
  )
(let [__ juxt*]
  (every? true?
          [(= [21 6 1] ((__ + max min) 2 3 5 1 6 4))
           (= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello"))
           (= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))]
          ))

(let [__ juxt*]
  (every? true?
          [(= [21 6 1] ((__ + max min) 2 3 5 1 6 4))
           (= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello"))
           (= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))]
          ))


[(apply + [2 3 5 1 6 4]) (apply max  [2 3 5 1 6 4]) (apply min  [2 3 5 1 6 4])]

(map #(% %2) (map #(comp partial apply %) [+ max min]) [2 3 5 1 6 4])

((fn [& p] #(map (partial %) p) + max min) 2 3 5 1 6 4)
((juxt* :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10})

((fn [& p] p) + max min)

;; install unzip in cygwin and make sure that emacs can see it