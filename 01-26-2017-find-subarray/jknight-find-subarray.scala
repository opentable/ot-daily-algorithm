import scala.annotation.tailrec

object FindSubarray extends App {
  @tailrec
  def findZeroSumSubArray(sum: Int, numbers: List[Int]): Boolean =
    if (sum == 0) true else numbers match {
      case Nil => false
      case 0 :: _ => true // if any of the numbers are 0, there is a subarray of size 1
      case head :: tail => findZeroSumSubArray(sum + head, tail)
    }

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
