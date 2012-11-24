/*
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
*/

def isTriplet(a: Int, b: Int, c: Int): Boolean = {
  math.pow(a,2) + math.pow(b,2) == math.pow(c,2)
}

def multTriplet(t: Tuple3[Int,Int,Int]): Int = {
  t.productIterator.foldLeft(1) { 
    case(acc,i) => acc.asInstanceOf[Int] * i.asInstanceOf[Int]
  }
}

def findTriplet: (Int, Int, Int) = {
  for (i <- 1 to 500) {
    var iTriplet = isTriplet(i, _:Int, _:Int)
    for (j <- i to 500) {
      var jTriplet = iTriplet(j,_:Int)
      for (k <- j to 500) {
        var kTriplet = jTriplet(k)
        if (kTriplet && (i + j + k == 1000)) { 
          return (i,j,k)
        }
      }
    }
  }
  return (-1,-1,-1)
}
var res = findTriplet
if (!res.equals((-1,-1,-1))) {
  println(multTriplet(res))
}
