################################################################################
# Euler #3
################################################################################
#
# The prime factors of 13195 are 5, 7, 13 and 29.
# 
# What is the largest prime factor of the number 600851475143 ?
#
################################################################################
#
# 6857
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

prime-factor = (num) ->
  all-primes = sieve-of-eratosthenes(num) |> reverse
  max-factor = for prime in all-primes
    if num % prime is 0
      return prime
  return max-factor

console.log prime-factor 600851475143