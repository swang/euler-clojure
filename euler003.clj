;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #3
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; The prime factors of 13195 are 5, 7, 13 and 29.
; 
; What is the largest prime factor of the number 600851475143 ?
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 6857
;

(use '[clojure.contrib.lazy-seqs :only (primes)])
; function from: http://vitalyper.wordpress.com/2011/01/13/project-euler-clojure-problem-003/

(defn prime-factors [n]
    (let [f (some #(if (= 0 (rem n %)) %) primes)]
        (if (= f n) 
            #{f} 
            (conj (prime-factors (/ n f)) f))))

(def z 600851475143N)

(println (apply max (prime-factors z)))