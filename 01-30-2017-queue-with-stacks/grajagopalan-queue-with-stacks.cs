public class QueueUsingStacks<T>
{
       private readonly Stack<T> _firstStack;

       private readonly Stack<T> _secondStack;

       public QueueUsingStacks()
       {
           _firstStack = new Stack<T>();
           _secondStack = new Stack<T>();
       }

       public void Enqueue(T item)
       {
           _firstStack.Push(item);
       }

       public T Dequeue()
       {
           if (_secondStack.Count > 0)
           {
               return _secondStack.Pop();
           }

           EnsureFirstStackIsNotEmpty();

           while (_firstStack.Count > 1)
           {
               var item = _firstStack.Pop();
               _secondStack.Push(item);
           }

           return _firstStack.Pop();
       }

       public int Count()
       {
           return _firstStack.Count + _secondStack.Count;
       }

       public T Peek()
       {
           if (_secondStack.Count > 0)
           {
               return _secondStack.Peek();
           }

           EnsureFirstStackIsNotEmpty();

           var items = _firstStack.ToArray();
           return items[0];
       }

       private void EnsureFirstStackIsNotEmpty()
       {
           if (_firstStack.Count <= 0)
           {
               // throw more apprppriate exception such as QueueIsEmptyException
               throw new ApplicationException("Queue is empty");
           }
       }
}

[TestFixture]
public class QueueUsingStacksTests
{
    [Test]
    public void Enqueue_Dequeue_Peek_Test()
    {
        var queue = new QueueUsingStacks<int>();
        queue.Enqueue(1);
        Assert.AreEqual(1, queue.Dequeue());
        Assert.AreEqual(0, queue.Count());

        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);

        Assert.AreEqual(1, queue.Dequeue());
        Assert.AreEqual(2, queue.Dequeue());
        Assert.AreEqual(3, queue.Dequeue());
        Assert.AreEqual(0, queue.Count());

        queue.Enqueue(10);
        queue.Enqueue(20);
        Assert.AreEqual(10, queue.Dequeue());
        Assert.AreEqual(20, queue.Peek());
        Assert.AreEqual(1, queue.Count());
    }
}
