;;This is the inverse of <a href='92'>Problem 92</a>, but much easier. Given an integer smaller than 4000, return the corresponding roman numeral in uppercase, adhering to the <a href='http://www.numericana.com/answer/roman.htm#valid'>subtractive principle</a>.
;; cgrand
#(apply str
   (mapcat
      (fn [[x v i] d]
        ([[] [i] [i i] [i i i] [i v]
          [v] [v i] [v i i] [v i i i] [i x]]
         (mod (quot % d) 10)))
      (partition 3 2 "??MDCLXVI")
      [1000 100 10 1]))


;; chouser
(fn f [[n & a] [s & b] o i]
  (if n
    (f a b (into o (repeat (int (/ i n)) s)) (rem i n))
    (apply str o)))
[1000 900 500 400 100 90 50 40 10  9 5  4 1]
'[  M  CM   D  CD   C XC  L XL  X IX V IV I]
[]

;;bradediger's solution:
(fn [n]
   (let [m (sorted-map-by > 1000 "M", 900 "CM", 500 "D", 400 "CD",
                          100 "C",  90 "XC",  50 "L", 40 "XL",
                          10 "X",   9 "IX",   5 "V", 4 "IV",
                          1 "I")]
     (loop [a [], r n]
       (if (zero? r)
         (apply str a)
         (let [k (first (filter #(<= % r) (keys m)))]
           (recur (conj a (m k)) (- r k)))))))

(let [__ (fn [i]
	   (apply str
		  (map name
		       (reverse (map #(if (pos? %2) (nth % (dec %2)) "")
				     [[:I :II :III :IV :V :VI :VII :VIII :IX]
				      [:X :XX :XXX :XL :L :LX :LXX :LXXX :XC]
				      [:C :CC :CCC :CL :D :DC :DCC :DCCC :CM]
				      [:M :MM :MMM]]
				     (reverse (map #(. Integer parseInt (str %) 10) (str i))))))))]
  (every? true?
	  [(= "I" (__ 1))
	   (= "XXX" (__ 30))
	   (= "IV" (__ 4))
	   (= "CXL" (__ 140))
	   (= "DCCCXXVII" (__ 827))
	   (= "MMMCMXCIX" (__ 3999))
	   (= "XLVIII" (__ 48))])
	  )


(zipmap "IVXLCDM" [1 5 10 50 100 500 1000])
;;       ^^
;;       ^ ^ ^ ^
{4 "IV" 40 "XL" 400 "CD"}
{9 "IX" 90 "XC" 900 "CM"}




(str ({1 "M"} 1)
     ({1 "C" 4 "CD" 5 "D" 9 "CM"} 3 3)
     ({1 "X" 4 "XL" 5 "L" 9 "CM"} 4 4)
     ({1 "I" 4 "IV" 5 "V" 9 "IX"} 5 5))

 


(map #(. Integer parseInt (str %) 10) (str 1345))
;;(1 3 4 5)
;;     XL V
;;MCCCXLV



{   1 :I    2 :II    3 :III   4 :IV    5 :V    6 :VI    7 :VII   8 :VIII   9 :IX
   10 :X   20 :XX   30 :XXX  40 :XD   50 :D   60 :DX   70 :DXX  80 :DXXX  90 :XC
  100 :C  200 :CC  300 :CCC 400 :CD  500 :D  600 :DC  700 :DCC 800 :DCCC 900 :CM
 1000 :M 2000 :MM 3000 :MMM }
(into () (map #(. Integer parseInt (str %) 10) (str 3999)))
(reverse (map #(. Integer parseInt (str %) 10) (str 3999)))

(apply str
       (map name
	    (reverse (map #(if (pos? %2) (nth % (dec %2)) "")
			  [[:I :II :III :IV :V :VI :VII :VIII :IX]
			   [:X :XX :XXX :XL :L :LX :LXX :LXXX :XC]
			   [:C :CC :CCC :CL :D :DC :DCC :DCCC :CM]
			   [:M :MM :MMM]]
			  (reverse (map #(. Integer parseInt (str %) 10) (str 3999)))))))

(fn [i] (apply str
	       (map name
		    (reverse (map #(nth % (dec %2))
				  [[:I :II :III :IV :V :VI :VII :VIII :IX]
				   [:X :XX :XXX :XL :L :LX :LXX :LXXX :XC]
				   [:C :CC :CCC :CL :D :DC :DCC :DCCC :CM]
				   [:M :MM :MMM]]
				  (reverse (map #(. Integer parseInt (str %) 10) (str i))))))))

(name (keyword "foo"))
(nth r 0)







{           1 :I    2 :II    3 :III
   4 :IV    5 :V    6 :VI    7 :VII 8 :VIII
   9 :IX   10 :X   20 :XX   30 :XXX
  40 :XD   50 :D   60 :DX   70 :DXX 80 :DXXX
  90 :XC  100 :C  200 :CC  300 :CCC
 400 :CL  500 :L  600 :LC  700 :lCC 800 :LCCC
 900 :CM 1000 :M 2000 :MM 3000 :MMM
 }



[:aN :a :aa :aaa]

[:i :ii :iii :iN]

()

(merge (zipmap "IVXLCDM" [1 5 10 50 100 500 1000])
       (zipmap ["VI" "IX" "XL" "XC" "CD" "CM"] [4 9 40 90 400 900]))

(zipmap (partition 2 2 "VIIXXLXCCDCM") [4 9 40 90 400 900])
(zipmap [1000 900 500 400 100 90 50 40 10 9 5 4 1],
	["M" "CM" "D" "CD" "C" "XC" "L" "XL" "X" "IX" "V" "IV" "I"])

{1 "I" 4 "IV" 100 "C" 900 "CM" 5 "V" 40 "XL" 1000 "M" 9 "IX" 10 "X" 400 "CD" 50 "L" 500 "D" 90 "XC"}

(for [x 1345 :let [v [1000 900 500 400 100 90 50 40 10 9 5 4 1]
		   r ["M" "CM" "D" "CD" "C" "XC" "L" "XL" "X" "IX" "V" "IV" "I"]]
      ])


(max (keys ))


[1000 500 100 50 10 5 1]

(map #(. Integer parseInt (str %) 10) (str 1345))

1345

1345=MCCCXLV

1000  + 100 + 100 + 100 + 

(mod 1345 1000)
(mod 345 100)

(.replace "abcad." #"([a-z]+)" "")


(def reduce-I (replace-re #"IIIII" "V"))
(def reduce-V (replace #"VV" "X"))
(def reduce-X (replace #"XXXXX" "L"))
(def reduce-L (replace #"LL" "C"))
(def reduce-C (replace #"CCCCC" "D"))
(def reduce-D (replace #"DD" "M"))

(def rewrite-9 (replace #"VIV" "IX"))
(def rewrite-90 (replace #"LXL" "XC"))
(def rewrite-900 (replace #"DCD" "CM"))
(def rewrite-I (replace #"IIII" "IV"))
(def rewrite-X (replace #"XXXX" "XL"))
(def rewrite-C (replace #"CCCC" "CD"))

(reduce-I "IIIIIIIIII")

(defn reduce-numeral [str]
  (-> str
      (replace-re #"IIIII" "V") (reduce-V) (reduce-X) (reduce-L) (reduce-C) (reduce-D)
      (rewrite-I)(rewrite-X) (rewrite-C) (rewrite-9)(rewrite-90)(rewrite-900)))


(defn reduce-numeral [str]
  (-> str
      (reduce-I) (reduce-V) (reduce-X) (reduce-L) (reduce-C) (reduce-D)
      (rewrite-I)(rewrite-X) (rewrite-C) (rewrite-9)(rewrite-90)(rewrite-900)))

(deftest test-reduce-numeral
  (is (= (reduce-numeral "IIIIIIIIIIIIIIII")
	 "XVI"))
  (is (= (reduce-numeral "MCCCCCCVI")
	 "MDCVI"))
  (is (every? #(= % "XVI")  ; 16
	      (map #(reduce-numeral %) ["XVI" "XIIIIII" "VVVI"])))
  (is (every? #(= % "XIX")  ; 19
	      (map #(reduce-numeral %) ["XIX" "XVIIII" "XVIV"])))
  (is (every? #(= % "XLIX") ; 49
	      (map #(reduce-numeral %) ["XXXXVIIII" "XXXXIX" "XLVIIII" "XLIX"]))))



