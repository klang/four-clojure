;;<a href="http://en.wikipedia.org/wiki/Pascal%27s_triangle">Pascal's triangle</a> is a triangle of numbers computed using the following rules:<br/></br>- The first row is 1.</br>- Each successive row is computed by adding together adjacent numbers in the row above, and adding a 1 to the beginning and end of the row.<br/><br/>Write a function which returns the nth row of Pascal's Triangle.


;; backticking and slicing can be used outside of a macro!??
(comment
  (fn p [x]
    (if (= x 1)
      [1]
      `[1 ~@(map + (p (- x 1)) (next (p (- x 1)))) 1]))
  )

(let [__ (fn[n] (last (take n (iterate (fn [r] (vec (concat [1] (map #(apply + %) (partition 2 1 r)) [1] ))) [1]))))]
  (every? true?
          [(= (__ 1) [1])
           (= (map __ (range 1 6))
              [     [1]
                    [1 1]
                    [1 2 1]
                    [1 3 3 1]
                    [1 4 6 4 1]])
           (= (__ 11)
              [1 10 45 120 210 252 210 120 45 10 1])]
          ))

(defn nextrow [row]
  (vec (concat [1] (map #(apply + %) (partition 2 1 row)) [1] )))


(nextrow [3 1 2])

(nextrow [1])

(defn pascal [n]
  (assert (and (integer? n) (pos? n)))
  (let [triangle (take n (iterate nextrow [1]))]
    (doseq [row triangle]
      (println row))))

(defn factorial [n] 
  (reduce * (range n 0 -1)))

(defn C [n k]
  (/ (factorial n) (* (factorial k) (factorial (- n k)))))

(C 4 2)

(#(take % (iterate nextrow [1])) 6)
((fn[n] (last (take n (iterate nextrow [1])))) 6)

((fn[n] (take n (iterate (fn [r] (vec (concat [1] (map #(apply + %) (partition 2 1 r)) [1] ))) [1]))) 6)


(defn nextrow [row]
  (vec (concat [1] (map #(apply + %) (partition 2 1 row)) [1] )))

(defn pasc [n])
