;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #16
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
;
; What is the sum of the digits of the number 2^1000?
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 1366
;

(require '[clojure.math.numeric-tower :as math])
(use '[clojure.string :only (split)])

(println 
    (reduce 
        + 
        (map 
            #(Integer/parseInt %1)
            (rest 
                (split 
                    (str 
                        (math/expt 2 1000)
                    )
                    #""
                )
            )
        )
    )
)