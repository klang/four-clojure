;;Write a function which will split a sequence into two parts.

(let [__ #(vector (take % %2) (drop % %2))]
  (every? true?
          [(= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
           (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
           (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])]
          ))
(let [__ (juxt take drop)]
  (every? true?
          [(= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
           (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
           (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])]
          ))

[(take 3 [1 2 3 4 5 6]) (drop 3 [1 2 3 4 5 6])]
(vector (take % %2) (drop % %2))