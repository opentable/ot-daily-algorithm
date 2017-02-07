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

object Solution extends App {

  def isValidBST(current: Tree[Int], min: Int = Integer.MIN_VALUE, max: Int = Integer.MAX_VALUE): Boolean = current match {
    case Empty => true
    case Node(value, _, _) if value < min || value > max => false
    case Node(value, left, right) => isValidBST(left, min, value - 1) && isValidBST(right, value + 1, max)
  }

  assert(isValidBST(Node(2, left = Node(1), right = Node(3))))
  assert(isValidBST(Node(4, left = Node(2, Node(1), Node(3)), right = Node(6, Node(5), Node(7)))))
  assert(!isValidBST(Node(5, Node(7), Node(3))))
}