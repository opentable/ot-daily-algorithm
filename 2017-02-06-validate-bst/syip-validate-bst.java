package validatebst;
/**
 * @author syip
 *  Validate BST
 *  Implement a function to check if a Binary Search Tree is a Binary Search Tree.
 *  Solution: recursive tree traversal O(n)
 */
public class ValidateBST {
    public static class Node<T>{
        Node left, right;
        T value;
        Node(T value) {this.value = value;}
    }
    public static boolean isValidBST(Node curNode, int floor, int ceiling) {
        if (curNode == null) return true;
        if ((int)curNode.value <= floor || (int)curNode.value >= ceiling) return false;
        boolean leftIsValid = isValidBST(curNode.left, floor, (int)curNode.value);
        boolean rightIsValid = isValidBST(curNode.right, (int)curNode.value, ceiling);
        return (leftIsValid && rightIsValid);
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(7);
        head.left = new Node<>(3);
        head.right = new Node<>(11);
        head.left.left = new Node<>(1);
        head.left.right = new Node<>(5);
        head.right.right = new Node<>(13);
        assert isValidBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
        head.right.left = new Node<> (7);
        assert !isValidBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }    
}
