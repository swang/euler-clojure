;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #14
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; The following iterative sequence is defined for the set of positive integers:
;
; n -> n/2 (n is even)
; n -> 3n + 1 (n is odd)
;
; Using the rule above and starting with 13, we generate the following sequence:
;
; 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
; It can be seen that this sequence (starting at 13 and finishing at 1) contains
; 10 terms. Although it has not been proved yet (Collatz Problem), it is thought
; that all starting numbers finish at 1.
;
; Which starting number, under one million, produces the longest chain?
;
; NOTE: Once the chain starts the terms are allowed to go above one million.
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 837799
;

(def chain-length (fn [n]
    ^{
        :doc "takes a number and returns the chain length based on the function written down in the comments"
        :test (fn []    (is (= (chain-length 1) 1))
                        (is (= (chain-length 2) 2))
                        (is (= (chain-length 3) 8))
                        (is (= (chain-length 4) 3))
                        (is (= (chain-length 7) 17))
                        (is (= (chain-length 8) 4))
                        (is (= (chain-length 13) 10))
                        (is (= (chain-length 1000) 112))                        
                        (is (= (chain-length 10000) 30))
        )
    }
    (loop [i n len 1]
        (if (= i 1)
            len
            (recur 
                (if (even? i)
                    (quot i 2)
                    (+ (* 3 i) 1)
                )
                (+ len 1)
            )
        )
    )
))
(println 
    (first (loop [num 1 which-num 1 max 0]
        (if (> num 1000000)
            [which-num max]
            (if (< max (chain-length num) )
                (recur (+ num 1) num (chain-length num) )
                (recur (+ num 1) which-num max)
            )
        )
    ))
)
