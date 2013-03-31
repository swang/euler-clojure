################################################################################
# Euler #7
################################################################################
#
# By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see 
# that the 6th prime is 13.
#
# What is the 10,001st prime number?
#
################################################################################
#
# 104743
#

# is-prime = (num) ->
#   return false if num % 2 is 0 and num isnt 2
#   n = 3
#   while n <= -~~~(num**0.5)
#     return false if num % n is 0
#     n += 2
#   return true

nth-prime = (nth) ->
  arr = [2]
  num = 3
  while (arr.length < nth)
    checkPrimer = 3
    while (checkPrimer^2 <= num)
      break if (num % checkPrimer is 0)
      checkPrimer++
    if (checkPrimer^2 > num)
      arr.push num
    num+=2
  return arr[*-1]

console.log nth-prime 10001