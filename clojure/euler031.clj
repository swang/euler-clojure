;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #31
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
;
; In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
;
; 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
; It is possible to make £2 in the following way:
;
; 1x£1 + 1x50p + 2x20p + 1x5p + 1x2p + 31p
; How many different ways can £2 be made using any number of coins?
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 73682

(println
    (reduce 
        + 
        (for [
                a (filter #(= 0 (mod %1 200))   (range 0 201))
                b (filter #(= 0 (mod %1 100))   (range 0 (- 201 a)))
                c (filter #(= 0 (mod %1 50))    (range 0 (- 201 a b)))
                d (filter #(= 0 (mod %1 20))    (range 0 (- 201 a b c)))
                e (filter #(= 0 (mod %1 10))    (range 0 (- 201 a b c d)))
                f (filter #(= 0 (mod %1 5))     (range 0 (- 201 a b c d e)))
                g (filter even?                 (range 0 (- 201 a b c d e f)))
                h                               (range 0 (- 201 a b c d e f g))
                    :when (= 200 (+ a b c d e f g h))
            ]
            1
        )
    )
)