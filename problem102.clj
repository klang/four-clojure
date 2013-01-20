;;When working with java, you often need to create an object with <code>fieldsLikeThis</code>, but you'd rather work with a hashmap that has <code>:keys-like-this</code> until it's time to convert. Write a function which takes lower-case hyphen-separated strings and converts them to camel-case strings.

(let [__ #(let [s (.split #"-" %) ]
    (apply str
           (flatten (merge
                     (map
                      (fn [s][(str(char(-(int(first s))32))(apply str (rest s)))])
                      (drop 1 s))
                     (take 1 s)))))]
  (every? true?
          [(= (__ "something") "something")
           (= (__ "multi-word-key") "multiWordKey")
           (= (__ "leaveMeAlone") "leaveMeAlone")]
          ))

(comment
  #(let [s (clojure.string/split % #"-")]
     (apply str (first s) (map clojure.string/capitalize (rest s)))))



(defn uc[c](-(int c)32))
(.replaceAll "multi-word-key" "-(.)" ((comp str char uc char first) "$1"))
;; returns uc of "$1" --> (str (char (uc (char (first "$1"))))) => ^D

(re-find matcher)
(re-groups matcher)

(defn uc[c](-(int c)32))
(defn ucfirst[s](str(char(-(int(first s))32))(apply str (rest s))))

(ucfirst "word")

((juxt take drop) 1 (.split #"-" "multi-word-key"))
((juxt take drop) 1 (.split #"-" "nothing"))

(map ucfirst (drop 1 (.split #"-" "nothing")))

(apply str
       (flatten (merge
                 (map ucfirst (drop 1 (.split #"-" "multi-word-key")))
                 (take 1 (.split #"-" "multi-word-key")))))

(#(apply str
         (flatten (merge
                   (map ucfirst (drop 1 %))
                   (take 1 %)))) (.split #"-" "multi-word-key"))
(#(apply str
         (flatten (merge
                   (map ucfirst (drop 1 %))
                   (take 1 %)))) (.split #"-" "nothing"))
(#(apply str
         (flatten (merge
                   (map (fn [s][(str(char(-(int(first s))32))(apply str (rest s)))]) (drop 1 %))
                   (take 1 %)))) (.split #"-" "nothing"))

(#(let [s (.split #"-" %)
        ]
    (apply str
           (flatten (merge
                     (map
                      ucfirst
                      (drop 1 s))
                     (take 1 s)))))
 "multi-word-key")

(#(let [s (.split #"-" %) ]
    (apply str
           (flatten (merge
                     (map
                      (fn [s][(str(char(-(int(first s))32))(apply str (rest s)))])
                      (drop 1 s))
                     (take 1 s)))))
 "multi-word-key")
