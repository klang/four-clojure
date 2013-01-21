;Let us define a binary tree as "symmetric" if the left half of the tree is the mirror image of the right half of the tree.  Write a predicate to determine whether or not a given binary tree is symmetric. (see <a href='/problem/95'>To Tree, or not to Tree</a> for a reminder on the tree representation we're using).

(fn [[_ n m]] (= n (flip m)))
(defn flip [[v n m]] (if (nil? v) v [v (flip m) (flip n)]))

(defn flip [[v n m]] (if (nil? v) v [v (flip m) (flip n)]))

(fn [[_ n m]]
  (letfn [(f [[v n m]] (if (nil? v) v [v (f m) (f n)]))] (= n (f m))))

(fn [[_ n m]](letfn[(f[[v n m]](if(nil? v)v[v (f m) (f n)]))](= n (f m))))

(fn [[_ n m]]
  (letfn [(f[[v n m]](if v[v (f m) (f n)]v))]
    (= n (f m))))


#(= %
    ((fn f [[v l r :as n]]
       (if n
         [v (f r) (f l)]))
     %))


(if 9 "foo" "bar")

(let [__ #_(fn [[_ n m]] (= n (flip m)))
      (fn [[_ n m]]
        (letfn [(f[[v n m]]
                  (if v [v (f m) (f n)]))]
          (= n (f m))))
      ]
  (every? true?
          [(= (__ '(:a (:b nil nil) (:b nil nil))) true)
           (= (__ '(:a (:b nil nil) nil)) false)
           (= (__ '(:a (:b nil nil) (:c nil nil))) false)
           (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                   [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
                   true)
           (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                   [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
                   false)
           (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                   [2 [3 nil [4 [6 nil nil] nil]] nil]])
                   false)]
          ))


