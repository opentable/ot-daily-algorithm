object Solution extends App {

  def findDuplicate(nums: Seq[Int]): Int = {
    val n = nums.length - 1

    nums.sum - ((n * (n + 1)) / 2)
  }

  assert(findDuplicate(List(1, 2, 2, 3, 4, 5)) == 2)
  assert(findDuplicate(List(4, 3, 2, 5, 4, 1)) == 4)
}