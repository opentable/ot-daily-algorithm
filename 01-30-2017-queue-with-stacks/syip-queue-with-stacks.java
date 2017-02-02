package queuewithstacks;

import java.util.Stack;
/**
 * @author syip
 * Implement Queue using Stacks

 * We are given a stack data structure with push and pop operations. 
 * The task is to implement a queue using instances of the stack data 
 * structure and operations on them.

 * Stack - LIFO (Last in First Out) Queue - FIFO (First in First Out)
 * 
 * Solution: Utilize 2 stacks
 * count O(1), enqueue O(1), dequeue O(n), peek O(n)
 */

public class QueueWithStacks<T> {

    private Stack<T> stack1 = new Stack();
    private Stack<T> stack2 = new Stack();
    private int count = 0;
    
    public int count() {
        return count;
    }
    
    public void enqueue(T data) {
        stack1.push(data);
        count++;
    }
    
    public T dequeue() {
        if (count == 0) throw new RuntimeException("Queue is empty");

        if(!stack2.empty()) {
            count--;
            return stack2.pop();
        }
        reOrgStacks();
        count--;
        return stack2.pop();
    }
    
    public T peek() {
        if (count == 0) throw new RuntimeException("Queue is empty");
        if (!stack2.empty()) return stack2.peek();
        reOrgStacks();
        return stack2.peek();
    }
    
    private void reOrgStacks() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }
    
    
    public static void main(String[] args) {
        QueueWithStacks<Integer> queue = new QueueWithStacks<>();
        queue.enqueue(123);
        assert queue.count()==1;
        assert queue.dequeue()==123;
        
        boolean caughtIt = false;
        try {
            queue.dequeue();
        } 
        catch (RuntimeException e) {
            caughtIt = true;
        }
        assert caughtIt;
        
        queue.enqueue(20);
        queue.enqueue(21);
        queue.enqueue(22);
        queue.enqueue(23);
        assert queue.count() == 4;
        assert queue.dequeue() == 20;
        queue.enqueue(24);
        assert queue.count() == 4;
        assert queue.dequeue() == 21;
        assert queue.count() == 3;
        assert queue.peek() == 22;
        assert queue.count() == 3;
    }
    
}
