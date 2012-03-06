;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #40
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; An irrational decimal fraction is created by concatenating the positive integers:
; 
; 0.123456789101112131415161718192021...
;              ^
;              +----------....
; It can be seen that the 12th digit of the fractional part is 1.
; 
; If d(n) represents the nth digit of the fractional part, find the value of the following expression.
; 
; d(1) x d(10) x d(100) x d(1000) x d(10000) x d(100000) x d(1000000)
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 210
;

(use '[clojure.string :only (split)])

(defn num-to-digits-seq [n]
    "split a number into a sequence of its digits (elements are numbers, not strings)"
    (map #(Integer/parseInt %) (rest (split (str n) #"")) ) )
    
(defn gen-seq [n]
    (cons 0
        (num-to-digits-seq
            (apply str (range 1 (inc n))))))
 
(def frac-part 
    (gen-seq (Math/ceil (/ (+ 1000000 9) 2)) )) 
    
(println
    (*
        (nth frac-part 1)
        (nth frac-part 10)
        (nth frac-part 100)
        (nth frac-part 1000)
        (nth frac-part 10000)
        (nth frac-part 100000)
        (nth frac-part 1000000)))
