;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #56
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; A googol (10^100) is a massive number: one followed by one-hundred zeros;
; 100^100 is almost unimaginably large: one followed by two-hundred zeros.
; Despite their size, the sum of the digits in each number is only 1.
;
; Considering natural numbers of the form, a^b, where a, b < 100, what is the 
; maximum digital sum?
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 972
;

(require '[clojure.math.numeric-tower :as math]) 
(use '[clojure.string :only (split)])

(defn num-to-digits-seq [n]
    "split a number into a sequence of its digits (elements are numbers, not strings)"
    (map #(Integer/parseInt %) (rest (split (str n) #"")) ) )

(println 
    (apply 
        max
        (for [
                a (range 1 100)
                b (range 1 100)
                :let [ a_power_b (reduce + (num-to-digits-seq (math/expt a b))) ]
            ]
            a_power_b)))
            