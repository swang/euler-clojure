/*
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
*/

/* Since I know that the answer would be a multiple of 2520, I just iterated 
through all permutations of 2520 until it spit out an answer that is divisible
by the numbers 1-20. */

// Range(2,divRange+1) generates range from 2 to divRange inclusive.
// forall is equivalent to all in Scala, meaning all numbers in list must return a true value
def isDiv(num:Int)(divRange: Int): Boolean = Range(2,divRange + 1).forall(num % _ == 0)

var divByAll = isDiv(_:Int)(20)
var i = 2520

while (!divByAll(i)) i += 2520

println(i)