################################################################################
# Euler #9
################################################################################
#
# A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
#
# a^2 + b^2 = c^2
# For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
#
# There exists exactly one Pythagorean triplet for which a + b + c = 1000.
# Find the product abc.
#
################################################################################
#
# 31875000
#

res = do -> 
  for a from 1 to 1000
    for b from a to (1000 - a)
       for c from b to (1000 - b - a)
          if a+b+c is 1000 and a^2 + b^2 is c^2
            return a * b * c 

# this might be more livescript-like 
# but it continues even after it finds the only answer
# res = [a*b*c for a in [1 to 1000] for b in [a to (1000 - a)] for c in [b to (1000 - b - a)] when a + b + c is 1000 and a^2+b^2 is c^2] |> head

console.log res