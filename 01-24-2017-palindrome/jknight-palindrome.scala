object Palindrome extends App {
  def isPalindrome(str: List[Char]): Boolean = str.reverse zip str forall {
    case (left, right) => left == right
  }

  assert(isPalindrome("racecar".toList))
  assert(!isPalindrome("random".toList))
}