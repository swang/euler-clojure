;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #39
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; If p is the perimeter of a right angle triangle with integral length sides, 
; {a,b,c}, there are exactly three solutions for p = 120.
;
; {20,48,52}, {24,45,51}, {30,40,50}
;
; For which value of p <= 1000, is the number of solutions maximised?
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 840


(def max_count 0)
(def max_p 1)
(def cur_count 0)

(loop [x 2]
    (if (< x 1001)
        (do        
            (def cur_count (count 
                (for [
                    a (range 1 (+ 1 (/ x 2)))
                    b (range a (+ 1 (/ x 2)))
                        :let [c (- x a b)]
                        :when  
                            (and 
                                (< 0 c)
                                (< c (+ a b))
                                (= (+ (* a a) (* b b)) (* c c))
                            )
                            
                    ]
                    (list a b c)
                )
            ))
            (if (< 
                    max_count
                    cur_count
                )
                (do 
                    (def max_count cur_count)
                    (def max_p x)
                )
            )
            (recur (+ x 1))
        )
    )
)
(println max_p)
