;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #33
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; 
; The fraction 49/98 is a curious fraction, as an inexperienced mathematician
; in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which 
; is correct, is obtained by cancelling the 9s.
; 
; We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
; 
; There are exactly four non-trivial examples of this type of fraction, less
; than one in value, and containing two digits in the numerator and
; denominator.
; 
; If the product of these four fractions is given in its lowest common terms,
; find the value of the denominator.
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 100 
;

(defn is-non-trivial-curious-fraction? ([n d]
    (if (>= n d) 
        false
        ; nf = numerator first digit
        ; ns = numerator second digit
        ; df = denominator first digit
        ; ds = denominator second digit
        (let [
            nf (int (/ n 10))
            ns (mod n 10)
            df (int (/ d 10))
            ds (mod d 10)
            ]
            (if 
                (or 
                    (and (= nf ds) (= (/ n d) (/ ns df)))
                    (and (= df ns) (= (/ n d) (/ nf ds))))
                true
                false)))))

(println 
    (let [ntcf (for 
        [
            a (remove #(= 0 (mod % 10)) (range 10 100))
            b (remove #(= 0 (mod % 10)) (range a 100))
            :when (is-non-trivial-curious-fraction? a b)
        ]
        [a b])]
        (denominator 
            (/ 
                (reduce * (map #(first %) ntcf))
                (reduce * (map #(second %) ntcf))))))