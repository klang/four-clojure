;;Roman numerals are easy to recognize, but not everyone knows all the rules necessary to work with them. Write a function to parse a Roman-numeral string and return the number it represents.
<br /><br />
You can assume that the input will be well-formed, in upper-case, and follow the <a href="http://en.wikipedia.org/wiki/Roman_numerals#Subtractive_principle">subtractive principle</a>. You don't need to handle any numbers greater than MMMCMXCIX (3999), the largest number representable with ordinary letters.

;;(def v (zipmap [\I \V \X \L \C \D \M] [1 5 10 50 100 500 1000]))
;;(def v {\I 1 \V 5 \X 10 \L 50 \C 100 \D 500 \M 1000})
;;(fn [r] (apply +  (map #(if (< (v %) (v %2)) (- (v %)) (v %)) r  (rest (str r "I")))))

(let [__
      (fn [r]
        (let [v {\I 1 \V 5 \X 10 \L 50 \C 100 \D 500 \M 1000}]
          (apply + (map #(if (< (v %) (v %2)) (- (v %)) (v %)) r  (rest (str r \I))))))]
  (every? true?
          [(= 14 (__ "XIV"))         ;; (+ 10 -1 4)
           (= 827 (__ "DCCCXXVII"))  ;; (+ 500 100 100 100 10 10 5 1 1)
           (= 3999 (__ "MMMCMXCIX")) ;; (+ 1000 1000 1000 -100 1000 -10 100 -1 10)
           (= 48 (__ "XLVIII"))      ;;  (+ -10 50 5 1 1 1) 
           ]
          ))

(def v (zipmap [\I \V \X \L \C \D \M] [1 5 10 50 100 500 1000]))

(reduce +  (map #(if (< (v %) (v %2)) (- (v %)) (v %)) (seq "DCCCXXVII")  (rest (seq "DCCCXXVII"))))
(apply +  (map #(if (< (v %) (v %2)) (- (v %)) (v %)) "DCCCXXVII"  (rest (str "DCCCXXVII" "I"))))
(apply +  (map #(if (< (v %) (v %2)) (- (v %)) (v %)) "MMMCMXCIX"  (rest (str "MMMCMXCIX" "I"))))


(fn [r] (apply +  (map #(if (< (v %) (v %2)) (- (v %)) (v %)) r  (rest (str r "I")))))

(fn [r] (let [v (zipmap [\I \V \X \L \C \D \M] [1 5 10 50 100 500 1000])]
          (apply + (map #(if (< (v %) (v %2)) (- (v %)) (v %)) r  (rest (str r "I"))))))

(fn [r] (let [v (zipmap [\I \V \X \L \C \D \M] [1 5 10 50 100 500 1000])]
          (apply + (map (fn [x y] (if (< (v x) (v y)) (- (v x)) (v x))) r  (rest (str r "I"))))))


(reduce +  (map #(if (< (v %) (v %2)) (- (v %)) (v %)) "DCCCXXVII"  "CCCXXVIII"))

(if (< (v \X) (v \L)) (- (v \X)))

;; I	1
;; V	5
;; X	10
;; L	50
;; C	100
;; D	500
;; M	1,000


;; A number written in Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. In the above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.

;; The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear more than three times if they appear non-sequentially, such as XXXIX.) "D", "L", and "V" can never be repeated.[7][8]

;; "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted

;; Only one small-value symbol may be subtracted from any large-value symbol.