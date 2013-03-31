################################################################################
# Euler #10
################################################################################
#
# The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
# 
# Find the sum of all the primes below two million.
#
################################################################################
#
# 142913828922
#

sieve-of-eratosthenes = (num) ->
  p = 2
  r = [2 to num]
  primes = []
  while (p^2 < num)
    primes.push p
    r = [v for v in r | v%p isnt 0]
    p = r[0]
  primes ++ r

console.log sieve-of-eratosthenes(1_999_999_million) |> sum