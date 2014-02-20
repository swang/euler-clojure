;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #52
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; It can be seen that the number, 125874, and its double, 251748, contain 
; exactly the same digits, but in a different order.
;
; Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, 
; contain the same digits.
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 142857
;

(use '[clojure.string :only (split)])

(def num-to-digits-str-seq (fn [x]
	^{  :doc "split a number into a sequence of its digits (elements are strings, not numbers)"
	    :test (fn []    (is (= (num-to-str-list 1234) ["1" "2" "3" "4"]))) }
    (rest (split (str x) #"") )))

(defn same-digits [coll]
    "returns true if all elements in collection contain the same digits"
    (if (<= (count coll) 1)
        true
        (if 
            (= 
                (sort (num-to-digits-str-seq (first coll))) 
                (sort (num-to-digits-str-seq (second coll)))
            )
            (same-digits (rest coll))
            false)))
            
(println
    (loop [x 10000]
        (if (same-digits (list x (* 2 x) (* 3 x) (* 4 x) (* 5 x) (* 6 x)))
            x
            (recur (inc x)))))
            