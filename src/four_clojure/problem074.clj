;;Given a string of comma separated integers, write a function which returns a new comma separated string that only contains the numbers which are perfect squares.
(map #(. Integer parseInt %) (.split "4,5,6,7,8,9" ","))
(map #(- (int (first %)) 48) (.split "4,5,6,7,8,9" ","))

(clojure.string/join "," (range 9))
(apply str (interpose "," (range 9)))

(filter #(= % (* (int (Math/sqrt %)) (int (Math/sqrt %)))) [4 5 6 7 8 9])



( (fn [s] (->>
	   (map #(. Integer parseInt %) (.split s ","))
	   (filter #(= % (* (int (Math/sqrt %)) (int (Math/sqrt %)))))
	   (clojure.string/join ",")
	   )) "4,5,6,7,8,9")

(let [__ (fn [s] (->>
	   (map #(. Integer parseInt %) (.split s ","))
	   (filter #(= % (* (int (Math/sqrt %)) (int (Math/sqrt %)))))
	   (clojure.string/join ",")
	   ))]
  (every? true?
	  [(= (__ "4,5,6,7,8,9") "4,9")
	   (= (__ "15,16,25,36,37") "16,25,36")]
	  ))

(let [__ ]
  (every?
   true?
   [(= (filter #(= % (* (int (Math/sqrt %))
			(int (Math/sqrt %)))) [4 5 6 7 8 9])
       [4 9])
    (= (filter #(= % (* (int (Math/sqrt %))
			(int (Math/sqrt %)))) [15 16 25 36 37])
       [16 25 36])]
   ))

(int (Math/sqrt 4))

(filter #(= % (* (int (Math/sqrt %)) (int (Math/sqrt %)))) [4 5 6 7 8 9])




(map #(* % %)
     (map #(int (Math/sqrt %)) [4 5 6 7 8 9]))


(->> [4 5 6 7 8 9]
     (map #(int (Math/sqrt %)))
     (map #(* % %)))

