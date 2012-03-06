;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #6
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; The sum of the squares of the first ten natural numbers is,
; 1^2 + 2^2 + ... + 10^2 = 385
;
; The square of the sum of the first ten natural numbers is,
; (1 + 2 + ... + 10)^2 = 55^2 = 3025
; Hence the difference between the sum of the squares of the first ten natural 
; numbers and the square of the sum is 3025  385 = 2640.
;
; Find the difference between the sum of the squares of the first one hundred
; natural numbers and the square of the sum.
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 25164150
;

; "pretty straightforward, took another approach using loop/reduce. figured this was a much better way to do this calculation (map and reduce vs loops)"

(def sum-squares (fn [i]
	"returns the sum of all squares from 1 to i. e.g. 1^2 + 2^2 + 3^2 + 4^2 where i=4"
	(reduce + (map #(* % %) (range 1 (+ i 1))))
))

(def square-sum (fn [i]
	"returns the square of the sum of all squares from 1 to i"
	(let [x (reduce + (range 1 (+ i 1)))] (* x x))
	
))

(println (- (square-sum 100) (sum-squares 100)))