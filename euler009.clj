;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #9
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
;
; a^2 + b^2 = c^2
; For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
;
; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
; Find the product abc.
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; Modeled after `for` loop created in euler004.clj
; 31875000
(println 
    (first (for [
        a (range 1 500)
        b (range a 500)
        c (range b 500)
        	:when (and (= (+ a b c) 1000) (= (+ (* a a) (* b b)) (* c c)))
        ]
        (* a b c)
        
    ))
)
