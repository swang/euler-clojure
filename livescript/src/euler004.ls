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

is-palindrome = (num) ->
  ((p) ->
    | p.length < 2 => (head p) is (last p)
    | (head p) is (last p) => is-palindrome(tail initial p)
    | otherwise false)(String(num))

x = [(x * y) for x in [100 to 999] for y in [100 to 999]]
    |> filter is-palindrome
    |> maximum
    
console.log x