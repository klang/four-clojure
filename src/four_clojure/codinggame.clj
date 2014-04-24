(defn distance [a b]
  (Math/sqrt (+ (Math/pow (- (a :x) (b :x)) 2) 
                (Math/pow (- (a :y) (b :y)) 2))))
(defn distance [[ax ay] [bx by]]
  (Math/sqrt (+ (Math/pow (- ax bx) 2) 
                (Math/pow (- ay by) 2))))

(defn distance [a b]
  (Math/sqrt (+ (Math/pow (- (a :x) (b :x)) 2) 
                (Math/pow (- (a :y) (b :y)) 2))))

http://mathforum.org/library/drmath/view/55417.html


(ns Player
	(:gen-class))

(defn distance [a b]
  (Math/sqrt (+ (Math/pow (- (a :x) (b :x)) 2) 
                (Math/pow (- (a :y) (b :y)) 2))))

(defn -main [& args]

	; Read init information from standard input, if any

    (def light {:x (read) :y (read)})
    (def thor {:x (read) :y (read)})

	(while true
		; Read inputs from Standard input using read
		(def n (read))

		; Compute logic here

		 (binding [*out* *err*]
		 	(println "Debug messages..." "thor:" thor " light: " light "distance: " (distance light thor)))

		; Write outputs to Standard output using println
		(println "E")))
