(comment
	; took me a while, trying to figure out how to generate a list based on what i wanted
	; eventually found an example that generated a lazy-list using iterate
	; also figured out passing in closures (lambdas?) to represent a predicate in take-while 
	; and instead of using (fn) use #() shorthand.
)
(print
	(reduce 
		+ (filter even? 
			(take-while 
				#(< % 4000000)
				(map 
					first 
					(iterate 
						(fn [[a,b]] [b (+ a b)]) 
						[1 1]
					)
				)
			)
		)
	)

)