;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #97
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; 
; The first known prime found to exceed one million digits was discovered in 
; 1999, and is a Mersenne prime of the form 2^6972593-1; it contains exactly
; 2,098,960 digits. Subsequently other Mersenne primes, of the form 2^p-1, have
; been found which contain more digits.
;
; However, in 2004 there was found a massive non-Mersenne prime which contains 
; 2,357,207 digits: 28433*(2^7830457)+1.
;
; Find the last ten digits of this prime number.
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 8739992577
; 

(use '[clojure.string :only (split)])
(require '[clojure.math.numeric-tower :as math])

(defn modexp [base pow n]
  "returns the value of (base^pow) % n"

    (loop [s 1 u pow g base]
      (if (not= u 0)
        (recur 
          (if (= 1 (bit-and u 1))
            (mod (* s g) n)
            s)
          (bit-shift-right u 1) 
          (mod (* g g) n)
        )
        s)))
        
(println (+ (mod (* 28433 (modexp 2 7830457 10000000000N)) 10000000000N) 1))


