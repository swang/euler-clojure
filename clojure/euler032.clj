;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #32
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; We shall say that an n-digit number is pandigital if it makes use of all the 
; digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 
; through 5 pandigital.
;
; The product 7254 is unusual, as the identity, 39 x 186 = 7254, containing
; multiplicand, multiplier, and product is 1 through 9 pandigital.
;
; Find the sum of all products whose multiplicand/multiplier/product identity
; can be written as a 1 through 9 pandigital.
;
; HINT: Some products can be obtained in more than one way so be sure to only
; include it once in your sum.
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 45228
; 

(use '[clojure.string :only (split)])

(defn num-to-digits-seq [n]
    "split a number into a sequence of its digits (elements are numbers, not strings)"
    (map #(Integer/parseInt %) (rest (split (str n) #""))))
    
(defn is-pandigital [multiplicand multiplier]
  "returns true if multiplicand * multiplier = product contains the integers from 1-9"
  (= (sort (concat (num-to-digits-seq multiplicand) (num-to-digits-seq multiplier) (num-to-digits-seq (* multiplicand multiplier)) )) (range 1 10)))
  
(defn num-digits [n]
  "returns number of digits in sequence n"
  (if (nil? (first n))
    0
    (+ (num-digits (rest n)) (count (str (first n)) ) )))
    
(println 
  (reduce + 
    (distinct 
      (for [
        ; Generated ranges for a & b based on the output of what was a pandigital
        a (range 1 50) 
        b (range a 2001)
        	:when (and (= (num-digits (conj '() a b (* a b))) 9) (is-pandigital a b))
        ]
        (* a b) ))))