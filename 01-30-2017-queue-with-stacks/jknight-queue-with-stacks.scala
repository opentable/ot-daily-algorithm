import scala.collection.mutable
import scala.util.Try

/**
  * Non thread-safe, mutable queue. This is a naive solution that simply satisfies
  * the constraints of the daily problem
  */
sealed class MutableQueue[A] {
  private[this] val (in, out) = (mutable.Stack[A](), mutable.Stack[A]())

  def isEmpty: Boolean = in.isEmpty && out.isEmpty

  def enqueue(item: A): MutableQueue[A] = {
    in.push(item); this
  }

  def enqueue(first: A, second: A, rest: A*): MutableQueue[A] = {
    in.push(first).push(second).pushAll(rest); this
  }

  /**
    *  @throws java.util.NoSuchElementException
    */
  def dequeue(): A = {
    if (out.isEmpty)
      if (in.isEmpty) throw new NoSuchElementException("dequeue on empty queue")
      else do out.push(in.pop()) while (in.nonEmpty)

    out.pop()
  }
}

/**
  * Thread-safe, immutable queue. This is the preferred solution
  */
sealed class ImmutableQueue[+A] protected(private[this] val in: List[A], private[this] val out: List[A]) {
  def this() { this(Nil, Nil) }

  def isEmpty: Boolean = in.isEmpty && out.isEmpty

  def enqueue[B >: A](item: B): ImmutableQueue[B] = new ImmutableQueue(item :: in, out)

  def enqueue[B >: A](first: B, second: B, items: B*): ImmutableQueue[B] =
    new ImmutableQueue(items.toList reverse_::: second :: first :: in, out)

  /**
    *  @throws java.util.NoSuchElementException
    */
  def dequeue(): (A, ImmutableQueue[A]) = out match {
    case Nil if in.nonEmpty => val reverse = in.reverse; (reverse.head, new ImmutableQueue(Nil, reverse.tail))
    case head :: tail => (head, new ImmutableQueue(in, tail))
    case _ => throw new NoSuchElementException("dequeue on empty queue")
  }
}

object QueueWithStacks extends App {
  var mutableQueue = new MutableQueue().enqueue(1, 2, 3)
  assert(1 == mutableQueue.dequeue())
  assert(2 == mutableQueue.dequeue())
  assert(3 == mutableQueue.dequeue())

  assert(mutableQueue.isEmpty)

  mutableQueue = new MutableQueue().enqueue(1).enqueue(2)
  assert(1 == mutableQueue.dequeue())

  mutableQueue.enqueue(3, 4, 5)
  assert(2 == mutableQueue.dequeue())
  assert(3 == mutableQueue.dequeue())
  assert(4 == mutableQueue.dequeue())
  assert(5 == mutableQueue.dequeue())

  assert(mutableQueue.isEmpty)
  assert(Try(mutableQueue.dequeue()).isFailure)

  def assertImmutableDequeue(num: Int, queue: ImmutableQueue[Int]): ImmutableQueue[Int] = {
    val (x, y) = queue.dequeue()
    assert(num == x)
    y
  }

  def assertImmutableDequeue(range: TraversableOnce[Int], queue: ImmutableQueue[Int]): ImmutableQueue[Int] =
    range.foldLeft(queue)((queue, num) => assertImmutableDequeue(num, queue))

  var immutableQueue = new ImmutableQueue().enqueue(1, 2, 3)

  immutableQueue = assertImmutableDequeue(1 to 3, immutableQueue)
  assert(immutableQueue.isEmpty)

  immutableQueue = new ImmutableQueue().enqueue(1).enqueue(2)

  immutableQueue = assertImmutableDequeue(1, immutableQueue)
  immutableQueue = immutableQueue.enqueue(3, 4, 5, 6, 7)
  immutableQueue = assertImmutableDequeue(2 to 5, immutableQueue)

  assert(!immutableQueue.isEmpty)

  immutableQueue = assertImmutableDequeue(6 to 7, immutableQueue)

  assert(immutableQueue.isEmpty)
  assert(Try(immutableQueue.dequeue()).isFailure)
}