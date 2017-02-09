package palindrome;
import java.util.Stack;
/**
 * @author syip
 * Palindrome
 * Implement a function to check if a linked list is a palindrome.
 * 
 * Solution: Assumes singly linked list, push nodes into stack until mid then 
 * validate from mid to end with nodes in stack O(n)
 */
public class Palindrome {
    public static class Node <T>{
        Node next;
        T value;
        Node(T value) { this.value = value; }
    }
    public static boolean isPalindrome(Node head) {
        Stack<Node> stack = new Stack<>();
        Node oneStep = head;
        Node twoStep = head;
        while (twoStep != null) {
            stack.push(oneStep);
            oneStep = oneStep.next;
            if (twoStep.next == null) {
                stack.pop();
                break;
            }
            twoStep = twoStep.next.next;
        }
        while(!stack.empty()) {
            if (!stack.pop().value.equals(oneStep.value)) return false;
            oneStep = oneStep.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Node<Character> head = new Node('a');
        Node<Character> tmpPointer = head;
        tmpPointer.next = new Node('b');
        tmpPointer = tmpPointer.next;
        tmpPointer.next = new Node('b');
        tmpPointer = tmpPointer.next;
        tmpPointer.next = new Node('a');
        tmpPointer = tmpPointer.next;
        assert isPalindrome(head);
        tmpPointer.next = new Node('a');
        tmpPointer = tmpPointer.next;
        assert !isPalindrome(head);   
    }
}
