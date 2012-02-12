;A palindromic number reads the same both ways. The largest palindrome made from the ;product of two 2-digit numbers is 9009 = 91  99.
;Find the largest palindrome made from the product of two 3-digit numbers.
(use '[clojure.string :only (split)])

(def num-to-str-coll (fn [x]
	"converts a number into a collection of digits"
	(rest (split (Integer/toString x) #"") )
))
(def coll-to-num (fn [x]
	"converts a collection like ("1" "2" "3" "4" into a number: 1234 "
	;(if (> (count x) 0 )
		(Integer/parseInt (apply str x))
	;	0
	;)
))
(def is-palidrome (fn [x]
	(if (< (count (num-to-str-coll x)) 2)
		true
		(if (= (first (num-to-str-coll x)) (last (num-to-str-coll x)))
			(is-palidrome (coll-to-num (butlast (rest (num-to-str-coll x)))))
			false
		)
	)
))


(println (is-palidrome 1234))

(println (is-palidrome 4444))
(println (reduce max (for [
	a (range 100 1000)
	b (range 100 1000)
	;:when (< a 15)
 	:when ( is-palidrome (* a b))
	]
	(* a b)
)))