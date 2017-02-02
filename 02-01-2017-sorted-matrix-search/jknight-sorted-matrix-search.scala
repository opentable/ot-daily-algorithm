import scala.annotation.tailrec

object Solution extends App {

  def searchMatrix(matrix: Array[Array[Int]], key: Int): Option[(Int, Int)] = {

    @tailrec
    def searchMatrixHelper(row: Int, col: Int): Option[(Int, Int)] =
      if (row >= matrix.length || col < 0) None else matrix(row)(col) match {
        case num if num == key => Some(row -> col)
        case num if num > key => searchMatrixHelper(row, col - 1)
        case num if num < key => searchMatrixHelper(row + 1, col)
      }

    if (matrix.isEmpty) None else searchMatrixHelper(0, matrix(0).length - 1)
  }

  val matrix = Array(Array(0, 1, 2, 3), Array(4, 5, 6, 7), Array(8, 9, 10, 11))

  assert(searchMatrix(matrix, 6).contains(1 -> 2))
  assert(searchMatrix(matrix, 11).contains(2 -> 3))
  assert(searchMatrix(matrix, 12).isEmpty)
  assert(searchMatrix(matrix, 0).contains(0 -> 0))
}