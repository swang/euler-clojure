;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #38
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; 
; Take the number 192 and multiply it by each of 1, 2, and 3:
;
; 192 x 1 = 192
; 192 x 2 = 384
; 192 x 3 = 576
;
; By concatenating each product we get the 1 to 9 pandigital, 192384576. 
; We will call 192384576 the concatenated product of 192 and (1,2,3)
;
; The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, 
; and 5, giving the pandigital, 918273645, which is the concatenated product 
; of 9 and (1,2,3,4,5).
; 
; What is the largest 1 to 9 pandigital 9-digit number that can be formed as
; the concatenated product of an integer with (1,2, ... , n) where n > 1?
;
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 932718654
;

(use '[clojure.string :only (split)])

(def num-to-digits-str-seq (fn [x]
    ^{  :doc "split a number into a sequence of its digits (elements are strings, not numbers)"
        :test (fn []    (is (= (num-to-digits-str-seq 1234) ("1" "2" "3" "4")))) }
    (rest (split (str x) #"") )))
    
(defn is-pandigital ([n]
    (= '("1" "2" "3" "4" "5" "6" "7" "8" "9") (sort (num-to-digits-str-seq n)))))

(defn is-pandigital2 ([n]
    (let [nn (Integer/parseInt n)]
        (= '(1 2 3 4 5 6 7 8 9)
         (sort [
            (mod (int (/ nn 1)) 10)
            (mod (int (/ nn 10)) 10)
            (mod (int (/ nn 100)) 10)
            (mod (int (/ nn 1000)) 10)
            (mod (int (/ nn 10000)) 10)    
            (mod (int (/ nn 100000)) 10)
            (mod (int (/ nn 1000000)) 10)
            (mod (int (/ nn 10000000)) 10)
            (mod (int (/ nn 100000000)) 10)])))))

(println
    (apply 
        max 
            (for [
                n (range 1 10000)
                a (range 1 10)
                :let [res (apply str (map #(* n %) (range 1 a))) ]
                :when (and (= (count res) 9) (is-pandigital res))
            ]
            (Integer/parseInt res)))) 
