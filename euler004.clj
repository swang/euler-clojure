;A palindromic number reads the same both ways. The largest palindrome made from the ;product of two 2-digit numbers is 9009 = 91  99.
;Find the largest palindrome made from the product of two 3-digit numbers.
(use '[clojure.string :only (split)])

(def num-to-str-list (fn [x]
	^{ 
	    :doc "converts a number x into a list of digits"
	    :test (fn []    (is (= (num-to-str-list 1234) ["1" "2" "3" "4"])))
	}
	(into [] (rest (split (Integer/toString x) #"") ))
))

(def is-palidrome (fn [x]
    ^{
        :doc "returns true if number x reads the same front and back"
        :test (fn []    (is (= (is-palidrome 1234) false))
                        (is (= (is-palidrome 1221) true))
                        (is (= (is-palidrome 1) true))
                        (is (= (is-palidrome 12213) false))
        )
    }
    (loop [number (num-to-str-list x)]
        (if (or (empty? number) (= 1 (count number)))
            true
            (if (not (= (first number) (last number)))
                false
                (recur (into [] (rest (butlast number))))
            )
        )
    )
))
(println 
    (reduce max (for [
        a (range 100 1000)
        b (range 100 1000)
        	:when ( is-palidrome (* a b))
        ]
        (* a b)
    ))
)
