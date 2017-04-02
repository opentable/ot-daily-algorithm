package oddevenlinkedlist;
/**
 * @author syip
 * Odd Even Linked List
 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and 
 * O(nodes) time complexity.
 * Example:
 * Given 1->2->3->4->5->NULL return 1->3->5->2->4->NULL.
 * 
 * Solution: Maintain two lists, one odd index and one even index, merge lists at the end O(n)
 */
public class OddEvenLinkedList {
    public static class Node {
        Node next;
        Integer value;
        Node() {}
        Node(Integer value) { this.value = value; }
        
        public static Node genNodeList(int[] values) {
            Node head = new Node();
            Node tmp = head;
            for(int i = 0; i < values.length; i++) {
                tmp.next = new Node(values[i]);
                tmp = tmp.next;
            }
            return head.next;
        }
        public static boolean nodesMatchArray(Node node, int[] values) {
            for (int i = 0; i < values.length; i++) {
                if (node==null || (int)node.value != values[i]) return false;
                node=node.next;
            }
            return (node==null);
        }
    }
    public static Node getOddEvenLinkedList(Node root) {
        Node currentNode = root;
        Node oddIndexListIterator = new Node();
        Node evenIndexListIterator = new Node();
        Node oddIndexListHead = oddIndexListIterator;
        Node evenIndexListHead = evenIndexListIterator;
        int currentIndex = 1;
        while (currentNode != null) {
            if (currentIndex % 2 == 1) {
                oddIndexListIterator.next = currentNode;
                oddIndexListIterator = oddIndexListIterator.next;
            } else {
                evenIndexListIterator.next = currentNode;
                evenIndexListIterator = evenIndexListIterator.next;
            }
            currentNode = currentNode.next;
            currentIndex++;
        }
        evenIndexListIterator.next = null;
        oddIndexListIterator.next = evenIndexListHead.next;
        return oddIndexListHead.next;
    }

    public static void main(String[] args) {
        Node head = Node.genNodeList(new int[] {1,2,3,4,5});
        Node partitionList = getOddEvenLinkedList(head);
        assert Node.nodesMatchArray(partitionList, new int[] {1,3,5,2,4});

        head = Node.genNodeList(new int[] {4});
        partitionList = getOddEvenLinkedList(head);
        assert Node.nodesMatchArray(partitionList, new int[] {4});
        
        head = Node.genNodeList(new int[] {6,5,4,3,2,1});
        partitionList = getOddEvenLinkedList(head);
        assert Node.nodesMatchArray(partitionList, new int[] {6,4,2,5,3,1});
        
        head = null;
        partitionList = getOddEvenLinkedList(head);
        assert partitionList == null;
    }
}
