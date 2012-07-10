;;Write a function which returns true if the given sequence is a palindrome.<br/><br>
                Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)

;;             (let [r (reverse %)] (if (string? %) (apply str r) r))
(let [__ #(= % (if (string? %) (apply str (reverse %)) (reverse %) ))]
  (every? true?
          [(false? (__ '(1 2 3 4 5)))
           (true? (__ "racecar"))
           (true? (__ [:foo :bar :foo]))
           (true? (__ '(1 1 3 3 1 1)))
           (false? (__ '(:a :b :c)))])
  )
;; #(= (seq %) (reverse %))


(comment
  (apply str (reverse "racecar"))
  (= [:foo :bar :foo] (reverse [:foo :bar :foo]))
  (seq? [:foo :bar :foo])
  (string? "racecar")
  #(= % (if (seq? %) (apply str (reverse %)) (reverse %))))