trait PalindromeFilter[T] extends Function[List[T], List[T]]

object PalindromeFilter {
  implicit def toNumericEvidence[T : Numeric]: PalindromeFilter[T] = new PalindromeFilter[T] {
    def apply(v1: List[T]) = v1
  }

  implicit val charEvidence: PalindromeFilter[Char] = new PalindromeFilter[Char] {
    private[this] val Pattern = """([a-zA-Z0-9])""".r

    def apply(v1: List[Char]) = v1 collect { case Pattern(x) => x.toLower }
  }
}

object Palindrome extends App {
  /**
    * Ad-hoc polymorphism allows validating palindromes for types other than List[Char]
    */
  def isPalindrome[T](pattern: List[T])(implicit filter: PalindromeFilter[T]): Boolean = {
    val filteredPattern = filter(pattern)

    filteredPattern.reverse zip filteredPattern forall {
      case (left, right) => left == right
    }
  }

  assert(isPalindrome("racecar".toList))
  assert(isPalindrome("A man, a plan, a canal, Panama!".toList))
  assert(!isPalindrome("random".toList))

  assert(isPalindrome(List(1, 2, 3, 4, 3, 2, 1)))
  assert(!isPalindrome(List(1, 2, 3, 4, 5)))

  assert(isPalindrome(List(1L, 2L, 3L, 4L, 3L, 2L, 1L)))
  assert(!isPalindrome(List(1L, 2L, 3L, 4L, 5L)))
}