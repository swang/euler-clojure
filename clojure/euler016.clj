;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #16
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
;
; What is the sum of the digits of the number 2^1000?
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 1366
;

(require '[clojure.math.numeric-tower :as math])
(use '[clojure.string :only (split)])

(defn num-to-digits-seq [n]
    "split a number into a sequence of its digits (elements are numbers, not strings)"
    (map #(Integer/parseInt %) (rest (split (str n) #"")) ) )

(println 
    (reduce 
        + 
        (num-to-digits-seq 
            (math/expt 2 1000))))
