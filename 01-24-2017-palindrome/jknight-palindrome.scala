object Palindrome extends App {
  val pattern = """([a-zA-Z0-9])""".r

  def isPalindrome(str: List[Char]): Boolean = {
    val filteredString = str collect {
      case pattern(x) => x.toLower
    }

    filteredString.reverse zip filteredString forall {
      case (left, right) => left == right
    }
  }

  assert(isPalindrome("racecar".toList))
  assert(!isPalindrome("random".toList))
  assert(isPalindrome("A man, a plan, a canal, Panama!".toList))
}