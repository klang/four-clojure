;:---- f#
open System.Numerics

let fibonacci =
   Seq.unfold
       (fun (a, b) -> Some(a, (b, a + b)))
       (BigInteger 0, BigInteger 1)

let c = Seq.head (Seq.skip 1000  fibonacci)

;;---- scala
def iterate[T](f: T=>T)(t:T): Stream[T] = t #:: iterate(f)(f(t))
def fibos:Stream[BigInt] = iterate[(BigInt,BigInt)](p => (p._2, p._1 + p._2))(0,1) map {p => p._1}

fibos drop 1000 head                            

;;---- clojure
(defn fibos [] 
  (map first 
       (iterate 
        (fn [[a b]] [b (+ a b)]) [0 1N])))

#'sandbox9135/fibos
> (take 1 (drop 100 (fibos)))
(354224848179261915075N)
> (take 1 (drop 1000 (fibos)))
(4346655768693745643568852767504
 (defn foo [[a b]] (+ a b))

 (second [1 2])
