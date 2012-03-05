;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #37
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; The number 3797 has an interesting property. Being prime itself, it is 
; possible to continuously remove digits from left to right, and remain prime 
; at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 
; 3797, 379, 37, and 3.
; 
; Find the sum of the only eleven primes that are both truncatable from left 
; to right and right to left.
; 
; NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 748317
;

(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn num-to-digit-seq [n]
    (map #(Integer/parseInt (str %)) (seq (str n) )))

(defn is-prime? [n]
    (and
        (or (= n 2) (odd? n))
        (number? 
            (some #{n} 
                (take-while 
                    (partial >= n)
                    primes)))))

(defn smush-seq
    "condenses a sequence into its numerical equivalent. e.g. (1 2 3 4) becomes 1234"
    ([n] (Integer/parseInt (apply str n))))

(defn generate-truncatable
    "generates both left truncatable and right truncatable numbers"
    ([n]
        (distinct 
            (concat
                (loop [nn (num-to-digit-seq n) r ()]
                    (if (not (empty? nn))
                        (recur (rest nn) (cons (smush-seq nn) r))
                        r
                    )
                )
                (loop [nn (butlast (num-to-digit-seq n)) r ()]
                    (if (not (empty? nn))
                        (recur (butlast nn) (cons (smush-seq nn) r))
                        r))))))

(println (reduce + (take 11
    (for 
        [
            p (remove #(< % 10) (take-while (partial > 1000000) primes))
            :when (every? is-prime? (generate-truncatable p))
        ]
        p))))