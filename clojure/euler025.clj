;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #25
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; The Fibonacci sequence is defined by the recurrence relation:

; Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.
; Hence the first 12 terms will be:

; F(1) = 1
; F(2) = 1
; F(3) = 2
; F(4) = 3
; F(5) = 5
; F(6) = 8
; F(7) = 13
; F(8) = 21
; F(9) = 34
; F(10) = 55
; F(11) = 89
; F(12) = 144
; The 12th term, F12, is the first term to contain three digits.
; 
; What is the first term in the Fibonacci sequence to contain 1000 digits?
; 
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 4782
;

(require '[clojure.math.numeric-tower :as math])
(use '[clojure.string :only (split)])

(defn take-until
    "Returns a lazy sequence of successive items that takes from coll until
    (pred item) returns true and grabs that last item where pred is first true. 
    pred must be free of side-effects."
    [pred coll]
    (lazy-seq
        (when-let [s (seq coll)]
            (if (pred (first s))
                (cons (first s) (take-until pred (rest s)))
                (cons (first s) '())
            )
        )
    )
)

(println
    (count
    	(take-until
    		(complement #(= (count (.toString %)) 1000))
    		(map 
    			first
    			(iterate 
    				(fn [[a,b]] [b (+ a b)]) 
    				[1N 1N]
    			)
    		)
    	)
    )
)