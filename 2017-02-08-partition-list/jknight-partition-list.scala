object Solution extends App {

  def partitionList(node: List[Int], partition: Int): List[Int] = {
    val (left, right) = node.foldLeft(List.empty[Int] -> List.empty[Int]) {
      case ((left, right), current) if current < partition => (current :: left) -> right
      case ((left, right), current) => left -> (current :: right)
    }

    left reverse_::: right.reverse
  }

  assert(partitionList(List(1, 4, 3, 2, 5, 2), 3) == List(1, 2, 2, 4, 3, 5))
}