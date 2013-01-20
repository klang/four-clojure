;;Write a function which finds all the anagrams in a vector of words.  A word x is an anagram of word y if all the letters in x can be rearranged in a different order to form y.  Your function should return a set of sets, where each sub-set is a group of words which are anagrams of each other.  Each sub-set should have at least two words.  Words without any anagrams should not be included in the result.

;; what?!?
;; #(->> % (group-by sort) vals (filter next) (map set) set)

(let [__
(fn [c] (set
         (filter #(< 1 (count %))
                 (vals (reduce
                        (fn [c w]
                          (let [k (sort w)]
                            (assoc c k (merge (get c k #{}) w))))
                        {} c)))))]
  (every? true?
          [(= (__ ["meat" "mat" "team" "mate" "eat"])
              #{#{"meat" "team" "mate"}})
           (= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
              #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})]
          ))


(#(sort %) "meat")


( #(reduce
    (fn [c x]
      (let [a (sort x)]
        (assoc c x (merge (get c a a) x) )))
    {} %)
  ["meat" "mat" "team" "mate" "eat"])


(def c {"aemt" #{"team" "mate"}})

(apply str (sort "meat"))

((fn [w] (let [k (apply str (sort w))]
           (merge (get c k w) w)))
 "meat")

((fn [w] (let [k (apply str (sort w))]
           (assoc c k (merge (get c k w) w))))
 "meat")

((fn [c w] (let [k (apply str (sort w))]
             (assoc c k (merge (get c k w) w))))
 {"aemt" #{"team" "mate"}}
 "meat")


((fn [c w] (let [k (apply str (sort w))]
             (assoc c k (merge (get c k #{}) w))))
 {}
 "meat")

(#(reduce
   (fn [c w] (let [k (apply str (sort w))]
               (assoc c k (merge (get c k #{}) w))))
   {} %)
 ["meat" "mat" "team" "mate" "eat"])


;;-----

(
 (fn [c] (reduce
          (fn [c w] (let [k (apply str (sort w))]
                      (assoc c k (merge (get c k #{}) w))))
          {} c))

  
 ["meat" "mat" "team" "mate" "eat"])

(set (filter #(< 1 (count %)) #{#{"eat"} #{"mat"} #{"mate" "meat" "team"}}))

(
 (fn [c] (set
          (filter #(< 1 (count %))
                  (set (vals (reduce
                              (fn [c w] (let [k (apply str (sort w))]
                                          (assoc c k (merge (get c k #{}) w))))
                              {} c))))))

  
 ["meat" "mat" "team" "mate" "eat"])

(
 (fn [c] (set
          (filter #(< 1 (count %))
                  (vals (reduce
                         (fn [c w]
                           (let [k (apply str (sort w))]
                             (assoc c k (merge (get c k #{}) w))))
                         {} c)))))
 ["meat" "mat" "team" "mate" "eat"])






