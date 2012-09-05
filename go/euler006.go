/*
################################################################################
# Euler #6
################################################################################
#
# The sum of the squares of the first ten natural numbers is,
# 1^2 + 2^2 + ... + 10^2 = 385
#
# The square of the sum of the first ten natural numbers is,
# (1 + 2 + ... + 10)^2 = 55^2 = 3025
# Hence the difference between the sum of the squares of the first ten natural 
# numbers and the square of the sum is 3025  385 = 2640.
#
# Find the difference between the sum of the squares of the first one hundred
# natural numbers and the square of the sum.
#
################################################################################
#
# 25164150
#
*/

// "pretty straightforward, took another approach using loop/reduce. figured 
// this was a much better way to do this calculation (map and reduce vs loops)"
package main 

import "fmt"

func sumSquares(n int) int {
	sum := 0
	for n > 0 {
		sum += n*n
		n--
	}
	return sum
}
func squareSum(n int) int {
	sum := 0
	for n > 0 {
		sum += n
		n--
	}
	return sum*sum
}

func main() {
	fmt.Println(squareSum(100) - sumSquares(100))
}
