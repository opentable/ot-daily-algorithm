import scala.annotation.tailrec

object FindSubarray extends App {
  @tailrec
  def findZeroSumSubArray(sum: Int, numbers: List[Int]): Boolean =
    if (sum == 0) true
    else if (numbers.isEmpty) false
    else findZeroSumSubArray(sum + numbers.head, numbers.tail)

  @tailrec
  def hasZeroSumSubArray(numbers: List[Int]): Boolean = numbers match {
    case Nil => false
    case head :: tail if findZeroSumSubArray(head, tail) => true
    case _ :: tail => hasZeroSumSubArray(tail)
  }

  assert(hasZeroSumSubArray(List(4, 2, -3, 1, 6)))
  assert(hasZeroSumSubArray(List(4, 2, 0, 1, 6)))
  assert(!hasZeroSumSubArray(List(-3, 2, 3, 1, 6)))
  assert(hasZeroSumSubArray(List(1, 2, 3, -3, -2, -1)))
}