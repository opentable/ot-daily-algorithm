package kdistancefromnode;
/**
 * @author syip
 * Print nodes at k distance from root
 * Given a root of a tree, and an integer k. Print all the nodes 
 * which are at k distance from root.
 *        1
 *      /   \
 *     2     3
 *    / \    /
 *   4   5  8 
 * 
 * Solution: Recursive tree traversal O(n)
 */
public class KDistanceFromNode {    
    public static class Node<T>{
        Node left, right;
        T value;
        Node(T value) {this.value = value;}
    }
    public static void printNodeKFromRoot(Node curNode, int targetLevel, int currentLevel) {
        if (currentLevel == targetLevel) {
            System.out.print(curNode.value + " ");
            return;
        }
        if (curNode.left != null) printNodeKFromRoot(curNode.left, targetLevel, currentLevel+1);
        if (curNode.right != null) printNodeKFromRoot(curNode.right, targetLevel, currentLevel+1);
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(3);
        head.left = new Node<>(5);
        head.right = new Node<>(8);
        head.left.left = new Node<>(9);
        head.left.right = new Node<>(10);
        head.right.right = new Node<>(11);
        printNodeKFromRoot(head, 0, 0);
        System.out.println();
        printNodeKFromRoot(head, 1, 0);
        System.out.println();
        printNodeKFromRoot(head, 2, 0);
    }
}
