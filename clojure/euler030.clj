;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #30
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; Surprisingly there are only three numbers that can be written as the sum of 
; fourth powers of their digits:
;
; 1634 = 1^4 + 6^4 + 3^4 + 4^4
; 8208 = 8^4 + 2^4 + 0^4 + 8^4
; 9474 = 9^4 + 4^4 + 7^4 + 4^4
; As 1 = 1^4 is not a sum it is not included.
;
; The sum of these numbers is 1634 + 8208 + 9474 = 19316.
;
; Find the sum of all the numbers that can be written as the sum of fifth powers
; of their digits.
; 
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 443839

; #30 and #34 are similar problems so I used what I did in #34 and applied it to this problem

(use '[clojure.string :only (split)])

(defn num-to-digits-seq [n]
    "split a number into a sequence of its digits (elements are numbers, not strings)"
    (map #(Integer/parseInt %) (rest (split (str n) #"")) ) )

(def sum-fifth-power-digits (fn [num]
    ^{
        :doc "Gets the sum of the fifth power of each digit in [num]"
        ;:test (fn []    (is (= (sum-fact-digits 0) 1)))
    }
    (reduce 
        + 
        (map 
            #(Math/pow % 5) 
            (num-to-digits-seq num)))))

(println 
    (reduce + 
        (for [
            i (range 2 1000000)
                :when (= i (int (sum-fifth-power-digits i)))
            ]
            i)))