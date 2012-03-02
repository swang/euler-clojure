;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #21
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; Let d(n) be defined as the sum of proper divisors of n (numbers less than n 
; which divide evenly into n).
; 
; If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and
; each of a and b are called amicable numbers.
;
; For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 
; 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 
; 71 and 142; so d(284) = 220.
;
; Evaluate the sum of all the amicable numbers under 10000.
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 31626
;

(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn divisors 
    ([d] (divisors d (+ 1 (int (/ d 2))) ))
    ([d n]
        (loop [s (range 1 (+ 1 n)) r []]
            (if (not-empty s)
                (if (zero? (mod d (first s) ))
                    (recur (rest s) (conj r (first s)))
                    (recur (rest s) r)
                )
                r
            )
        )
        
    )
)

(defn is-amicable 
    "returns true if n is amicable wherein amicable means d(n) = m & d(m) = n where a != b"
    ([n]
        (let [da (divisors n)
              db (reduce + (divisors (reduce + da)))
            ]
            (and (not= (reduce + da) db) (= n db))
        )
    )
)

(println 
    (reduce +
        (loop [s 1 amicable ()]
            (if (< s 10000)
                (if (and 
                        (not (contains? amicable s)) 
                        (is-amicable s)
                    )
                    (recur (inc s) (conj amicable s))
                    (recur (inc s) amicable)
                )
                amicable
            )
        )
    )
)