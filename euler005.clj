(comment
	"Since I know that the answer would be a multiple of 2520, I just iterated through all permutations of 2520 until it spit out an answer that is divisible by the numbers 1-20.
	Original is-div? function is inefficient since it continues to check even if the number is not divisible by 2. New is-div iterates through a range and returns false immediately when a number is not divisible."


)
(def old-is-div? (fn [x xrange]
	"Figures out if [x] is divisible by all the numbers in list [xrange]"
	(= (reduce + (map #(mod x %1) xrange)) 0)
))
(def is-div? (fn [x xrange]
	"Figures out if [x] is divisible by all the numbers in list [xrange], but faster"
	(if (empty? xrange)
		true
		(if (= (mod x (first xrange)) 0) 
			(is-div? x (next xrange))
			false
		)
	)
))
(loop [x 2520]
	(if (is-div? x (range 2 21))
 		(println x)
 		(recur (+ x 2520))
 	)
)
 