import scala.annotation.tailrec

object IsUnique extends App {
  def isUniqueSet(str: String): Boolean = str.distinct.length == str.length

  @tailrec
  def isUniqueRecursive(str: String): Boolean = str match {
    case _ if str.isEmpty => true
    case _ if str.substring(1) contains str.charAt(0) => false
    case _ => isUniqueRecursive(str.substring(1))
  }

  def isUniqueIterative(str: String): Boolean = {
    str.sorted reduce { (prev, current) => if (prev == current) return false
      current
    }

    true
  }

  def isUniqueSliding(str: String): Boolean = str.sorted.sliding(2) forall {
    case pair if pair.charAt(0) != pair.charAt(1) => true
    case _ => false
  }

  def isUniqueFoldLeft(str: String): Boolean = {
    str.foldLeft(Set.empty[Char]) { (accum, current) => if (accum contains current) return false
      accum + current
    }

    true
  }

  assert(isUniqueSet("abc"))
  assert(!isUniqueSet("abbc"))

  assert(isUniqueRecursive("abc"))
  assert(!isUniqueRecursive("abbc"))

  assert(isUniqueIterative("abc"))
  assert(!isUniqueIterative("abbc"))

  assert(isUniqueSliding("abc"))
  assert(!isUniqueSliding("abbc"))

  assert(isUniqueFoldLeft("abc"))
  assert(!isUniqueFoldLeft("abbc"))
}