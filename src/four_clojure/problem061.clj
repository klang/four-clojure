;;Write a function which takes a vector of keys and a vector of values and constructs a map from them.

(let [__ #(into {} (map (fn [a b] {a b}) % %2))]
  (every? true?
          [(= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
           (= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
           (= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})]
          ))

(into {} (map #(vector % %2) [:a :b :c] [1 2 3]))
(into {} (map #(hash-map % %2) [:a :b :c] [1 2 3]))

(into {} (map (fn [a b] {a b}) [:a :b :c] [1 2 3]))

( #(into {} (map (fn [a b] {a b}) % %2)) [:a :b :c] [1 2 3])