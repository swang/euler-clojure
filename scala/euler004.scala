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

// Yes `new StringBuffer(s).reverse()` will also work.
def reverse(s: String): String = { s.foldLeft("") { case(acc, s) => (s+acc) } }
def isPalindrome( s: String ): Boolean = { s.equals(reverse(s)) }

var largest = 0
for (i <- 100 until 1000) {
  var mlm = (j: Int) => j * i;
  for (k <- i until 1000) {
    var res = mlm(k)
    if (largest < res && isPalindrome(res.toString())  ) {
      largest = res
    }
  }
}
println(largest)