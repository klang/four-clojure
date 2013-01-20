;;Write a function which returns true if the given sequence is a palindrome.<br/><br>
                Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)

;;             (let [r (reverse %)] (if (string? %) (apply str r) r))
(let [__
      
(comment
  (apply str (reverse "racecar"))
  (= [:foo :bar :foo] (reverse [:foo :bar :foo]))
  (seq? [:foo :bar :foo])
  (string? "racecar")
  #(= % (if (seq? %) (apply str (reverse %)) (reverse %))))