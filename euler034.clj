;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #34
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
;
; Find the sum of all numbers which are equal to the sum of the factorial of their digits.
;
; Note: as 1! = 1 and 2! = 2 are not sums they are not included.
;
; 40730
(use '[clojure.string :only (split)])

(def fact (fn [num]
    ^{
        :doc "returns factorial of [num]"
        :test (fn []    (is (= (fact 0) 1))
                        (is (= (fact 1) 1))
                        (is (= (fact 2) 2))
                        (is (= (fact 10) 3628800))
        )
    }
    (reduce * (range 1 (+ 1 num)))
))

(def sum-fact-digits (fn [num]
    ^{
        :doc "Gets the sum of the factorial of each digit in [num]"
        :test (fn []    (is (= (sum-fact-digits 0) 1))
                        (is (= (sum-fact-digits 1) 1))
                        (is (= (sum-fact-digits 2) 2))
                        (is (= (sum-fact-digits 12) 3))
                        (is (= (sum-fact-digits 123) 9))
                        (is (= (sum-fact-digits 145) 145))
        )

    }
    (reduce + (map #(fact %) (map #(Integer/parseInt %) (rest (split (str num) #"") ))))
))

(println 
    (reduce + 
        (for [
            i (range 3 500000)
                :when (= i (sum-fact-digits i))
            ]
            i
        )
    )
)