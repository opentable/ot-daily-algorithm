import scala.annotation.tailrec

object Solution extends App {

  def matchStringEnds(str: String): String = {

    @tailrec
    def matchStringEndsHelper(start: Int, end: Int): Int =
      if (end >= str.length) start
      else if (str(start) == str(end)) matchStringEndsHelper(start + 1, end + 1)
      else if (start != 0) matchStringEndsHelper(0, end)
      else matchStringEndsHelper(0, end + 1)

    str.substring(0, matchStringEndsHelper(0, (str.length + 1) / 2))
  }

  assert(matchStringEnds("abcXYZueabYab") == "ab")
  assert(matchStringEnds("abXYab") == "ab")
  assert(matchStringEnds("xx") == "x")
  assert(matchStringEnds("xxx") == "x")
  assert(matchStringEnds("x") == "")
  assert(matchStringEnds("") == "")
}