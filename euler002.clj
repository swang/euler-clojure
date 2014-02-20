;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Euler #2
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; Each new term in the Fibonacci sequence is generated by adding the previous 
; two terms. By starting with 1 and 2, the first 10 terms will be:
;
; 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
;
; By considering the terms in the Fibonacci sequence whose values do not exceed
; four million, find the sum of the even-valued terms.
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
; 4613732
;

(comment
	; took me a while, trying to figure out how to generate a list based on what i wanted
	; eventually found an example that generated a lazy-list using iterate
	; also figured out passing in closures (lambdas?) to represent a predicate in take-while 
	; and instead of using (fn) use #() shorthand.
)
(println
	(reduce 
		+ (filter even? 
			(take-while 
				#(< % 4000000)
				(map 
					first 
					(iterate 
						(fn [[a,b]] [b (+ a b)]) 
						[1 1]))))))