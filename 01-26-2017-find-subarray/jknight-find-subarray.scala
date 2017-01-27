import scala.annotation.tailrec

object FindSubarray extends App {

  @tailrec
  def hasZeroSumSubArray(numbers: List[Int], seen: Set[Int] = Set.empty, sum: Int = 0): Boolean = numbers match {
    case Nil => false
    case 0 :: _ => true
    case head :: _ if seen.contains(sum + head) || sum + head == 0 => true
    case head :: tail => hasZeroSumSubArray(tail, seen + (sum + head), sum + head)
  }

  assert(hasZeroSumSubArray(List(4, 2, -3, 1, 6)))
  assert(hasZeroSumSubArray(List(4, 2, 0, 1, 6)))
  assert(!hasZeroSumSubArray(List(-3, 2, 3, 1, 6)))
  assert(hasZeroSumSubArray(List(1, 2, 3, -3, -2, -1)))
  assert(hasZeroSumSubArray(List(3, -2, -1)))
}