;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #23
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; 
; A perfect number is a number for which the sum of its proper divisors is 
; exactly equal to the number. For example, the sum of the proper divisors of 
; 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
; 
; A number n is called deficient if the sum of its proper divisors is less 
; than n and it is called abundant if this sum exceeds n.
; 
; As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
; number that can be written as the sum of two abundant numbers is 24. By
; mathematical analysis, it can be shown that all integers greater than 28123
; can be written as the sum of two abundant numbers. However, this upper limit
; cannot be reduced any further by analysis even though it is known that the
; greatest number that cannot be expressed as the sum of two abundant numbers
; is less than this limit.
; 
; Find the sum of all the positive integers which cannot be written as the
; sum of two abundant numbers.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; 
; 4179871
;

(defn divisors 
    ([d] (divisors d (+ 1 (int (/ d 2))) ))
    ([d n]
        (loop [s (range 1 (+ 1 n)) r []]
            (if (not-empty s)
                (if (zero? (mod d (first s) ))
                    (recur (rest s) (conj r (first s)))
                    (recur (rest s) r)
                )
                r))))
(defn is-abundant
    "an abundant number is a number where the sum of its factors is greater than itself. e.g. 12 = 1 2 3 4 5 6, => 16, 12 < 16"
    ([n] (< n (reduce + (divisors n)))))
(def abundants
    (filter #(not= % -1) (map #(if (is-abundant %) % -1) (range 12 28124)))) 
(println 
    (reduce + 
        (remove 
            (set 
                (for 
                    [
                        i (lazy-seq abundants)
                        j (lazy-seq abundants)
                        :when (and (< (+ i j) 28124))
                    ]
                    (+ i j)
                )
            )
            (range 1 28124))))
