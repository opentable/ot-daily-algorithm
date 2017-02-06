import scala.annotation.tailrec

object Solution extends App {

  @tailrec
  def bunnyEars(remaining: Int, count: Int = 0): Int =
    if (remaining == 0) count
    else bunnyEars(remaining - 1, count + (if (remaining % 2 == 0) 3 else 2))

  assert(bunnyEars(0) == 0)
  assert(bunnyEars(1) == 2)
  assert(bunnyEars(2) == 5)
  assert(bunnyEars(3) == 7)
}