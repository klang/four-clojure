;;When parsing a snippet of code it's often a good idea to do a sanity check to see if all the brackets match up. Write a function that takes in a string and returns truthy if all square [ ] round ( ) and curly { } brackets are properly paired and legally nested, or returns falsey otherwise.


(let [__ #(loop [s %]
    (let [n (clojure.string/replace s #"[^\(\)\[\]\{\}]|\(\)|\[\]|\{\}" "")]
      (if (= s n) (empty? s)
          (recur n))))]
  (every? true?
          [(__ "This string has no brackets.")
           (__ "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }")
           (not (__ "(start, end]"))
           (not (__ "())"))
           (not (__ "[ { ] } "))
           (__ "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))")
           (not (__ "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))"))
           (not (__ "["))])
 
         )

;; basic idea
;; if open bracket push to stack
;; if close bracket match to top of stack
;; otherwise, ignore

;; TODO: ignore everyting that isn't brackets
(defn balance
  ([input] (balance (rest input) (vector (first input))))
  ([input stack] 
     (cond
      (empty? input) (if (empty? stack) true false)
      (not (#{\( \) \[ \{ \] \}} (first input))) (balance (rest input) stack)
      (empty? stack) (balance input)
      (m (str (peek stack) (first input))) (balance (rest input) (pop stack))
      :else
      (balance (rest input) (conj stack (first input))))))

;; another idea
;; remove everything but braces
;; recursively match and remove (), [] and {}

(defn balance [z]
  (loop [s (apply str (filter (set "()[]{}") z)) ]
    (let [n (clojure.string/replace s #"\(\)|\[\]|\{\}" "") ]
      (if (= s n) (empty? s)
          (recur n)))))

(defn balance [z]
  (loop [s z]
    (let [n (clojure.string/replace s  #"[^\(\)\[\]\{\}]|\(\)|\[\]|\{\}" "") ]
      (if (= s n) (empty? s)
          (recur n)))))


(def legal "\(\)\[\]\{\}")

(clojure.string/replace "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }" #"[^\(\)\[\]\{\}]" "")

(clojure.string/replace "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }" #"[^\(\)\[\]\{\}]|\(\)|\[\]|\{\}" "")


(defn balance [z]
  (loop [s z]
    (let [n (clojure.string/replace s  #"[^\(\)\[\]\{\}]|\(\)|\[\]|\{\}" "") ]
      (if (= s n) (empty? s)
          (recur n)))))

(first "asdf")
(first (reverse "asdf"))

;; pop tokens off the head (first) of the string, until we meet "("
;; -- pop tokens off the tail (rest) of the string, until we meet ")"

(def t "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }")

(first t)
(last t)
(rest t)
(reverse (rest (reverse t)))
(remove #(not (set "()[]{}") t)
(filter (set "()") t)

(defn balance [t]
  (if (= (first t) \() ))

(defn balance-r [t]
  (if (= (last t) )))

(defn balance-l [t] 
  (if (= (first t) ))))

(comment
  #(not
    (reduce
     (fn [[a & m :as p] c]
       (if-let [r ({\[ \] \{ \} \( \)} c)]
         (cons r p)
         (cond
          (= c a) m
          (#{\] \} \)} c) %
          1 p)))
     nil
     %)))

(comment 
  #(empty? 
    (reduce 
     (fn [[a & r :as x] c]
       (cond
        (= ({\( \) \{ \} \[ \]} a) c) r
        ((set "(){}[]") c) (cons c x)
        1 x))
     [] 
     %)))

(comment 
  (fn [s]
    (let [pairs {\) \( \] \[ \} \{}]
      (= '() (reduce #(cond
                       (nil? %1) nil
                       ((set (vals pairs)) %2) (cons %2 %1)
                       (pairs %2) (if (= (pairs %2) (first %1)) (rest %1) nil)
                       :else %1) '() s))))
  )

(def pairs {\) \( \] \[ \} \{})
(def pairs {\) \(})

(pairs \()
(pairs \))

(defn balance [s c]
  (cond
   (nil? s)                   nil
   ((set (vals pairs)) c)     (cons c s)
   (pairs c)                  (if (= (pairs c) 
                                     (first s)) 
                                (rest s) 
                                nil)
   :else                      s
   ))



(let [__ 
      (fn [s] (= '() (reduce balance '() s)))]
  (every? true?
          [
           (__ "(if (zero? x) max (/ 1 x))")
           (not (__ ":-)"))
           (__ "I told him (that it's not (yet) done).\n(But he wasn't listening)")
           (not (__ "())("))
           (__ "This string has no brackets.")
           (__ "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }")
           (not (__ "(start, end]"))
           (not (__ "())"))
           (not (__ "[ { ] } "))
           (__ "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))")
           (not (__ "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))"))
           (not (__ "["))]))
