(comment
	"pretty straightforward, took another approach using loop/reduce. figured this was a much better way to do this calculation (map and reduce vs loops)"

)
(def sum-squares (fn [i]
	"returns the sum of all squares from 1 to i. e.g. 1^2 + 2^2 + 3^2 + 4^2 where i=4"
	(reduce + (map #(* % %) (range 1 (+ i 1))))
))

(def square-sum (fn [i]
	"returns the square of the sum of all squares from 1 to i"
	(let [x (reduce + (range 1 (+ i 1)))] (* x x))
	
))


(println (- (square-sum 100) (sum-squares 100)))