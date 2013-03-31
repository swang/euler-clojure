################################################################################
# Euler #5
################################################################################
#
# 2520 is the smallest number that can be divided by each of the numbers from 1 
# to 10 without any remainder.
#
# What is the smallest positive number that is evenly divisible by all of the 
# numbers from 1 to 20?
#
################################################################################
#
# 232792560
#

# Since I know that the answer would be a multiple of 2520, I just iterated
# through all permutations of 2520 until it spit out an answer that is
# divisible by the numbers 11-20.

is-div-all = (x) ->
 for i from 11 to 20
    return false if mod(x,i) isnt 0
 true

j = 2520
until is-div-all(j)
  j += 2520
console.log j