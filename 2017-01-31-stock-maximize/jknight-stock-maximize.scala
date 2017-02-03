import scala.io.StdIn._

object Solution extends App {
  (for {
    _ <- 1 to readInt()
    numPrices = readInt()
    stockPrices = readLine().split(" ").map(_.toLong).slice(0, numPrices)
  } yield stockPrices.foldRight(0L -> 0L) {
    case (current, (maximum, total)) if current > maximum => (current, total)
    case (current, (maximum, total)) => (maximum, total + (maximum - current))
  }) foreach { case (_, total) => println(total) }
}