;;Convert a binary number, provided in the form of a string, to its numerical value.

;; #(Integer/parseInt % 2)   <---- come on .. 
;; (fn [s] (reduce + (map #(* (- (int %)48) (apply * (repeat %2 2)))(reverse s) (range))))

(let [__ (fn [s] (reduce + (map #(* (- (int %)48) (apply * (repeat %2 2)))(reverse s) (range))))]
  (every? true?
          [(= 0     (__ "0"))
           (= 7     (__ "111"))
           (= 8     (__ "1000"))
           (= 9     (__ "1001"))
           (= 255   (__ "11111111"))
           (= 1365  (__ "10101010101"))
           (= 65535 (__ "1111111111111111"))]
          ))

(defn bin2int
  "returns the decimal representation of a binary string"
  [binary-string]
  (reduce + (map #(* (- (int  %1) 48) (expt 2 %2)) 
		 (reverse binary-string) (iterate inc 0))))

;;(. Integer toBinaryString 234)