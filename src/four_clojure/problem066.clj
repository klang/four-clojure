;;Given two integers, write a function which

;;#(loop [a % b %2] (if (= 0 b) a (recur b (mod a b))))
;;#(if (= 0 %2) % (recur %2 (mod % %2)))
;;#(if (= 0 %) %2 (recur (mod %2 %) %))

(let [__  #(if (= 0 %) %2 (recur (mod %2 %) %))]
  (every? true?
          [(= (__ 2 4) 2)
           (= (__ 10 5) 5)
           (= (__ 5 7) 1)
           (= (__ 1023 858) 33)]
          ))
