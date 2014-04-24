(def pairs {\) \( \] \[ \} \{})
(def pairs {\) \(})

(pairs \( );; nil
(pairs \) );; \(

((set (vals pairs)) \) );; nil
((set (vals pairs)) \( );; \(

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

(cond '() (rest "adsf"))


(defn balance [s c]
  (cond
   (nil? s) nil
   (= c \() (cons c s)
   (= c \)) (if (= \( (first s)) 
              (rest s) 
              nil)
   :else    s
   ))

(defn balance [s c]
  (if (nil? s) nil
      (if (= c \() (cons c s) 
          (if (= c \) ) 
            (if (= \( (first s)) 
              (rest s) 
              nil) 
            s))))

(balance "()" nil)


(reduce balance '() "()")

(let [__ 
      (fn [s] (= '() (reduce balance '() s)))]
  (every? true?
          [
           (__ "(if (zero? x) max (/ 1 x))")
           (not (__ ":-)"))
           (__ "I told him (that it's not (yet) done).\n(But he wasn't listening)")
           (not (__ "())("))]))





;; empty?
;; first
;; rest
;; -- helper function allowed

(defn balance 
  ([s]
     (if (empty? s) true
         (= (first s) \() (balance (rest s) c)
         ))
  ([s c])
  )

(use 'clojure.test)

(deftest test-balance
  (is (balance []))

  )

(defn balanced? [s]
  "Determine whether input string
   is balanced bracket sequence"
  (loop [[first & coll] (seq s)
	 stack '()]
    (if first
      (if (= first \[)
	(recur coll (conj stack \[))
	(when (= (peek stack) \[)
	  (recur coll (pop stack))))
      (zero? (count stack)))))



(defn balanced? [s]
  (loop [[first & coll] (seq s)
	 stack '()]
    (if first
      (if (= first \[)
	(recur coll (conj stack \[))
	(when (= (peek stack) \[)
	  (recur coll (pop stack))))
      (zero? (count stack)))))

(defn balanced? [s]
  (loop [[first & coll] (seq s)
	 stack '()]
    (if first
      (if (= first \[)
	(recur coll (conj stack \[))
	(if (= (peek stack) \[)
	  (recur coll (pop stack))))
      (zero? (count stack)))))

(defn balanced? [s]
  (loop [s  s
	 stack '()]
    (if (first s)
      (if (= (first s) \[)
	(recur (rest s) (conj stack (first s)))
	(if (= (peek stack) \[)
	  (recur (rest s) (pop stack))))
      (zero? (count stack)))))


(balanced? "[][[]]")
(balanced? "[][[adf]]")

(first "[][[]]")

(def s "[][[]]")
(def stack '())
;(def stack '(\[))

(first '(1 3 4))
(conj '(1 2 3) 4)
(peek '(1 2 3))
(pop '(1 2 3))
(rest '(1 2 3))

(defn balanced? 
  ([s] (balanced? s '()))
  ([s stack]
     (if (first s)
       (if (= (first s) \[)
         (balanced? (rest s) (conj stack (first s)))
         (if (= (first stack) \[)
           (balanced? (rest s) (rest stack))))
       (empty? stack))))

(empty? '())
(zero? (count '()))

(defn balanced? 
  ([s] (balanced? s '()))
  ([s stack]
     (if (first s)
       (if (= (first s) \[)
         (balanced? (rest s) (conj stack (first s)))
         (if (= (first stack) \[) 
           (balanced? (rest s) (rest stack))))
       (empty? stack))))

(defn balanced? 
  ([s] (balanced? s '()))
  ([s stack]
     (if (empty? s)
       (empty? stack)
       (if (= (first s) \[)
         #_{:s s :stack stack :first 1 :call {:s (rest s) :stack (conj stack (first s))}}
         (balanced? (rest s) (conj stack (first s)))
         #_{:s s 
          :stack stack 
          :first 2 
          :check {:fs (first s)
                  :fst (first stack) 
                  :if (and (= (first s) \]) (= (first stack) \[))}}
         (if (and
                (= (first s) \])
                (= (first stack) \[)) 
           #_{:s s :stack stack :call {:s (rest s) :stack (rest stack)}}
           (balanced? (rest s) (rest stack))
           #_{:s s :stack stack :call {:s (rest s) :stack stack}}
           (balanced? (rest s) stack)))
       )))


(defn balanced? 
  ([s] (balanced? s '()))
  ([s stack]
     (if (empty? s)
       (empty? stack)
       (if (= (first s) \()
         (balanced? (rest s) (conj stack (first s)))
         (if (and
                (= (first s) \))
                (= (first stack) \()) 
           (balanced? (rest s) (rest stack))
           (balanced? (rest s) stack)))
       )))

(balanced? "(aaaa)")
(balanced? "aaaa)" '(\())
(balanced? "))" '(\())
(balanced? ")" '())

(balanced? "(if (zero? x) max (/ 1 x))")
(balanced? "I told him (that it's not (yet) done).\n(But he wasn't listening)")

(balanced? "((aaa(")
(balanced? "((aaa(")
(balanced? "((aaa(")
(balanced? ":-)")

(defn balanced?
  ([xs] (balanced? xs '()))
  ([[x & xs] opens] 
   (let
     [match {\{ \}, \[ \], \( \)}
      closers #{ \} \] \) }]
     (cond
      (nil? x) (empty? opens)
      (match x) (recur xs (conj opens x))
      (closers x) (if (= x (match (first opens)))
                    (recur xs (rest opens))
                    false)
      :else (recur xs opens)))))


(defn balanced?
  ([xs] (balanced? xs []))
  ([[x & xs] opens] 
   (let
     [match {\{ \}, \[ \], \( \)}
      closers #{ \} \] \) }]
     (cond
      (nil? x) (empty? opens)
      (match x) (recur xs (conj opens x))
      (closers x) (if (= x (match (peek opens)))
                    (recur xs (pop opens))
                    false)
      :else (recur xs opens)))))
