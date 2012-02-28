;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #48
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
;
; Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 9110846700
;

(require '[clojure.math.numeric-tower :as math])
(use '[clojure.string :only (split)])

(defn split-number [x]
	"converts a number x into a list of digits"
	(into [] (rest (split (str x) #"") ))
)

(println 
    (apply 
        str
        (take-last 
            10 
            (split-number
                (reduce 
                    + 
                    (map 
                        #(math/expt % %) 
                        (range 1 1000)
                    )
                )
            )
        )
    )
)