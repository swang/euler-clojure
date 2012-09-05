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

package main

import "fmt"

func isDiv(x int) bool {
    for i := 20 ; i > 1; i-- {
        if x % i != 0 {
            return false
        }

    }
    return true;
}
func main() {
    x := 2520
    for isDiv(x) != true {
        x += 2520
    }
    fmt.Println(x)
}
