;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #36
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
;
; Find the sum of all numbers, less than one million, which are palindromic in 
; base 10 and base 2.
;
; (Please note that the palindromic number, in either base, may not include
; leading zeros.)
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 872187

(use '[clojure.string :only (split)])

(def num-to-str-list (fn [x]
	^{ 
	    :doc "converts a number x into a list of digits"
	    :test (fn []    (is (= (num-to-str-list 1234) ["1" "2" "3" "4"])))
	}
	(into [] (rest (split (str x) #"") ))
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

(println (reduce + 
    (for [
        x (range 1 1000001)
            :when (and (is-palidrome x) (is-palidrome (Integer/toBinaryString x)))
        ]
        x
    )
))
