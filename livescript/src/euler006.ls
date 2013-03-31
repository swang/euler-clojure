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

sum-squares = (last) ->
  [..*.. for [1 to last]] |> sum
square-sum = (last) ->
  ([1 to last] |> sum) ^ 2

console.log square-sum(100) - sum-squares(100)