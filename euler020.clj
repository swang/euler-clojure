;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #20
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; n! means n  (n  1)  ...  3  2  1
; 
; For example, 10! = 10  9  ...  3  2  1 = 3628800, and the sum of the digits 
; in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
; 
; Find the sum of the digits in the number 100!
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 648
;

; used bigint to solve problem of multiplying large numbers
 
(use '[clojure.string :only (split)])

(defn num-to-digits-seq [n]
    "split a number into a sequence of its digits (elements are numbers, not strings)"
    (map #(Integer/parseInt %) (rest (split (str n) #"")) ) )

(println 
    (reduce 
        + 
        (num-to-digits-seq
            (reduce 
                * 
                (map 
                    bigint 
                    (range 1 101))))))