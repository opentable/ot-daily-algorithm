package partitionlist;
/**
 * @author syip
 * Partition List
 * Given a linked list and a value x, partition it such that all nodes less 
 * than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of 
 * the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * Solution: Maintain two lists, one < and one >=, merge lists at the end O(n)
 */
public class PartitionList {
    public static Node getPartitionedList(Node node, int splitValue) {
        Node lessThanNodes = new Node();
        Node greaterEqualNodes = new Node();
        Node lessThanHead = lessThanNodes;
        Node greaterEqualHead = greaterEqualNodes;
        while (node != null) {
            if ((int)node.value < splitValue) {
                lessThanNodes.next = node;
                lessThanNodes = lessThanNodes.next;
            }
            else {
                greaterEqualNodes.next = node;
                greaterEqualNodes = greaterEqualNodes.next;
            }
            node = node.next;
        }
        if (greaterEqualNodes!=null) {
            greaterEqualNodes.next = null;
            lessThanNodes.next = greaterEqualHead.next;
        }
        return lessThanHead.next;
    }
    
    public static class Node <T>{
        Node next;
        T value;
        Node() {}
        Node(T value) { this.value = value; }
        public static Node genNodeList(int[] values) {
            Node<Integer> head = new Node();
            Node<Integer> tmp = head;
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
    
    public static void main(String[] args) {
        Node<Integer> head = Node.genNodeList(new int[] {1,4,3,2,5,2});
        Node<Integer> splitList = getPartitionedList(head, 3);
        assert Node.nodesMatchArray(splitList, new int[] {1,2,2,4,3,5});
        head = Node.genNodeList(new int[] {1,4,3,2,5,2});
        splitList = getPartitionedList(head, 7);
        assert Node.nodesMatchArray(splitList, new int[] {1,4,3,2,5,2});
        head = Node.genNodeList(new int[] {5,4,3,2,5,2});
        splitList = getPartitionedList(head, 1);
        assert Node.nodesMatchArray(splitList, new int[] {5,4,3,2,5,2});
    }
}
