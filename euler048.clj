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

(defn num-to-digits-seq [n]
    "split a number into a sequence of its digits (elements are numbers, not strings)"
    (map #(Integer/parseInt %) (rest (split (str n) #"")) ) )

(println
    (apply 
        str
        (take-last 
            10 
            (num-to-digits-seq
                (reduce 
                    + 
                    (map 
                        #(math/expt % %) 
                        (range 1 1000)))))))