;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #53
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; There are exactly ten ways of selecting three from five, 12345:
;
; 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
;
; In combinatorics, we use the notation, 5C3 = 10.
;
; In general,
;
; nCr =	n!/(r!(n-r)!),where r <= n, n! = nx(n-11)x...x3x2x1, and 0! = 1.
; It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
;
; How many, not necessarily distinct, values of nCr, for 1 <= n <= 100, are
; greater than one-million?
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 4075
;

(def fact ^BigInteger (fn [^Integer num]
    (biginteger (reduce * (range 1 (+ 1 num))))))
    
(defn comb ^BigInteger [^Integer n ^Integer r]
  (biginteger (/ (apply * (map #(biginteger %) (range (+ (- n r) 1) (+ n 1)))) (apply * (map #(biginteger %) (range 2 (+ 1 r))))))
)

(println
  (count  
    (for [n (range 23 101)
          r (range 2 (+ 1 n))
          :when (> (comb n r) 1000000)
        ]
        (comb n r))))