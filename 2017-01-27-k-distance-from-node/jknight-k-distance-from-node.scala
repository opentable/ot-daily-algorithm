import java.util.NoSuchElementException

sealed trait Tree[+T] {
  def isEmpty: Boolean

  def value: T
}

final case class Node[T](value: T, left: Tree[T] = Empty, right: Tree[T] = Empty) extends Tree[T] {
  def isEmpty: Boolean = false
}

case object Empty extends Tree[Nothing] {
  def isEmpty: Boolean = true

  def value: Nothing = throw new NoSuchElementException("value of empty node")
}

object KNode extends App {

  def calculateValsAtDepth(tree: Tree[Int], depth: Int): List[Int] = tree match {
    case Empty => List.empty

    case Node(_, left, right) if depth > 0 =>
      calculateValsAtDepth(left, depth - 1) :::
        calculateValsAtDepth(right, depth - 1)

    case Node(value, _, _) => List(value)
  }

  val btree = Node(1, left = Node(2, Node(4), Node(5)), right = Node(3, Node(8)))

  assert(calculateValsAtDepth(btree, 0) == List(1))
  assert(calculateValsAtDepth(btree, 1) == List(2, 3))
  assert(calculateValsAtDepth(btree, 2) == List(4, 5, 8))
  assert(calculateValsAtDepth(btree, 2) != List(1, 2, 3))
}