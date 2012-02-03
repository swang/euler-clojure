(comment
	; My plan here is to generate a list of numbers from 0-999, map this against whether the number divides by 3 or 5.
	; If it is divisible by 3 or 5, return the number, otherwise return 0.
	; Reduce this by summing up the list
	; Input: (1 2 3 4 5 6 7 8 9) 
	; Map->Output: (0 0 3 0 5 6 0 0 9) => 23
)

(print

	(reduce + 
		(map 
			#(if 
				(or (= (mod %1 3) 0) (= (mod %1 5) 0)) %1 0
			)
			
			(range 1 1000)
		)
	)
)