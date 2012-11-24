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

def sumOfSquares(lastNum: Int): Int = {
  Range(1,lastNum+1)
    .foldLeft(0) { case(acc, i) => acc + (math.pow(i,2)).toInt }
}

def squareOfSum(lastNum: Int): Int = {
  math.pow( Range(1,lastNum+1).sum , 2).toInt
}

println(squareOfSum(100) - sumOfSquares(100))