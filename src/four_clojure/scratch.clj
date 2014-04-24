(ns four-clojure.scratch
    (:use [clojure.math.numeric-tower :only (sqrt expt round)]
          #_[clojure.contrib.math :only (expt exact-integer-sqrt)]))

;(reduce + [1 2 3 4 5 ])


#_(defn m
  ([x] x)
  ([x y] (. clojure.lang.Numbers (m x y)))
  ([x y & more]
     (reduce m (m x y) more)))



#_(reduce #(if (< % %2) %2 %) [4 1 2 5 3])



#_(reduce #(if (< % %2) %2 %) [1 2])

;; #include <iostream>
;; 
;; int coins[8] = {200, 100, 50, 20, 10, 5,2,1};
;; 
;; int findposs(int money, int maxcoin)
;; {
;;     int sum = 0;
;;     if(maxcoin == 7) return 1;
;;     for(int i = maxcoin; i<8;i++)
;;     {
;;         if (money-coins[i] == 0) sum+=1;
;;         if (money-coins[i] > 0) sum+=findposs(money-coins[i], i);
;;     }
;;     return sum;     
;; }
;; 
;; int main()
;; {
;;     cout<<findposs(200, 0)<<endl;
;; }


;; main :: IO ()
;; main = print $ count [200,100,50,20,10,5,2,1] 200
;; 
;; count :: [Integer] -> Integer -> Integer
;; count _ 0      = 1
;; count [c] _    = 1
;; count (c:cs) s = sum $ map (count cs . (s-)) [0,c..s]

(defn count [c]
  (reduce + (map )))


(defn balance 
  [str] 
  (if (empty? str) true
      (balance (hea))))

(defn balance 
  ([[x & xs :as b]]
     {:x x :xs xs :b b}))
(balance "abcde")
(balance "")
(defn balance 
  ([[x & xs]]
     (if (nil? x) true
         (= x \() )))


;; empty?
;; first
;; rest

(defn balance 
  ([xs]
     (if (empty? xs) true
         ))
  ([[x xs] c] {:x x :xs xs}))

(balance "")
(balance "aa")




(defn balance 
  [xs] (if (empty? xs) true 
           (let [x (first xs)]
             (if (= x \( ) (balance (rest xs))
                 
                 )
             )))

(defn balance
  ([xs] 
     (if 
         (nil? xs) true
         (if (= (first xs) \()
           (balance (first xs) (rest xs))
           (balance (rest xs)))))
  ([x xs]
     
     (if (= x (first xs)) {:balance (rest xs)}#_(balance (rest xs))
         {:first (first xs) :rest (rest xs)}#_(balance (first xs) (rest xs))))
  )


(balance "a(())")
(balance "))")

;; if (and (= (first xs) "(") (= c ")")) return (rest xs)
;; 
(cons '(4) '(1 2 3) )
(cons [] "a")



  #(empty? 
    (reduce 
     (fn [[a & r :as x] c]
       (cond
        (= ({\( \) \{ \} \[ \]} a) c) r 
        ((set "(){}[]") c) (cons c x)
        1 x))
     [] 
     %))


(#(empty? 
   (reduce 
    (fn [[a & r :as x] c]
      (cond
       (= ({\( \)} a) c) r
       (#{\( \)} c)      (cons c x)
       1 x))
    [] 
    %)) 
"(()())()")

(def pairs {\) \(})
((set (vals pairs)) \()
(pairs \()
(pairs \))


( (fn [s]
    (= '() (reduce (fn [x y] 
                     (cond
                      (nil? x) nil
                      (= \( y) (cons y x)
                      (= \) y) (if (= \( (first x)) (rest x) nil)
                      :else x)) '() s))) "(()())()")

(defn bal [x y] 
  (cond
   (nil? x) nil
   (= \( y) (cons y x)
   (= \) y) (if (= \( (first x)) (rest x) nil)
   :else x))





(defn bal [x y] 
  (if (nil? x) nil
      (if (= \( y) (cons y x)
          (if (= \) y ) (if (= \( (first x)) (rest x)) x)))
  )



(bal '() "(()(()())))")


((fn [s]
   (= '() (reduce bal '() s))) "(()())()asdf(")

( (fn [s]
    (let [pairs {\) \(}]
      (= '() (reduce #(cond
                       (nil? %1) true
                       (= \( %2) (cons %2 %1)
                       (= \) %2) (if (= (pairs %2) (first %1)) (rest %1) nil)
                       :else %1) '() s)))) "(()())()")

(fn [s]
  (let [pairs {\) \( \] \[ \} \{}]
    (= '() (reduce #(cond
                     (nil? %1) nil
                     ((set (vals pairs)) %2) (cons %2 %1)
                     (pairs %2) (if (= (pairs %2) (first %1)) (rest %1) nil)
                     :else %1) '() s))))
