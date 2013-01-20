;;<p>A standard American deck of playing cards has four suits - spades, hearts, diamonds, and clubs - and thirteen cards in each suit. Two is the lowest rank, followed by other integers up to ten; then the jack, queen, king, and ace.</p>

<p>It's convenient for humans to represent these cards as suit/rank pairs, such as H5 or DQ: the heart five and diamond queen respectively. But these forms are not convenient for programmers, so to write a card game you need some way to parse an input string into meaningful components. For purposes of determining rank, we will define the cards to be valued from 0 (the two) to 12 (the ace)</p>

<p>Write a function which converts (for example) the string "SJ" into a map of <code>{:suit :spade, :rank 9}</code>. A ten will always be represented with the single character "T", rather than the two characters "10".</p>
(comment
  #(zipmap [:suit :rank]
           (map (zipmap "SHDC23456789TJQKA"
                        `(:spade :heart :diamond :club ~@(range)))
                %))
(fn[[s r]]
   {:suit({\D :diamond \H :heart \C :club}s)
    :rank((zipmap[\2\3\4\5\6\7\8\9\T\J\Q\K\A](range 13))r)})

  )

(let [__
(fn[[s r]]
   {:suit({\D :diamond \H :heart \C :club}s)
    :rank((zipmap[\2\3\4\5\6\7\8\9\T\J\Q\K\A](range 13))r)})]
  (every? true?
          [(= {:suit :diamond :rank 10} (__ "DQ"))
           (= {:suit :heart :rank 3} (__ "H5"))
           (= {:suit :club :rank 12} (__ "CA"))
           (= (range 13) (map (comp :rank __ str)
                              '[S2 S3 S4 S5 S6 S7
                                S8 S9 ST SJ SQ SK SA]))]
          ))

(zipmap '[2 3 4 5 6 7 8 9 T J Q K A] '(0 1 2 3 4 5 6 7 8 9 10 11 12))

((zipmap '[2 3 4 5 6 7 8 9 \T \J \Q \K \A] (range 13)) (second "DQ"))
#((zipmap '[\2\3\4\5\6\7\8\9\T\J\Q\K\A] (range 13)) (second %))

#((zipmap '[\2\3\4\5\6\7\8\9\T\J\Q\K\A] (range 13)) (second %))

((fn [[s r]]
   {:suit ({\D :diamond \H :heart \C :club \S :spade} s)
    :rank ((zipmap '[\2\3\4\5\6\7\8\9\T\J\Q\K\A] (range 13)) r)}) "DQ")
((fn [[s r]]
   {:suit ({\D :diamond \H :heart \C :club \S :spade} s)
    :rank ((zipmap "23456789TJQKA" (range)) r)}) "DQ")