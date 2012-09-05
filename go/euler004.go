/*
################################################################################
# Euler #4
################################################################################
#
# A palindromic number reads the same both ways. The largest palindrome made 
# from the product of two 2-digit numbers is 9009 = 91 99.
#
# Find the largest palindrome made from the product of two 3-digit numbers.
#
################################################################################
#
# 906609
#
*/

package main

import "fmt"
import "strconv"

func isPalindrome(n int) bool {
    strNum := strconv.Itoa(n)
    for i := 0; i < (len(strNum) / 2); i++ {
        if strNum[i] != strNum[len(strNum) - i - 1] {
            return false
        }
    }
    return true;
}

func main() {
    largest := 0

    for i := 100; i <= 999; i++ {
        for j := i+1; j <= 999; j++ {
            mult := i*j
            if isPalindrome(mult) && mult > largest {
                largest = mult
            }
        }
    }
    fmt.Println(largest)
}