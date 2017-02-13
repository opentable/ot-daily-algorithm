public class ListPartitioner {

    public <T extends Comparable<T>> Node<T> partition(Node<T> head, T partition) {

        if (head == null) {
            return null;
        }

        Node leftPartitionHead = null;
        Node rightPartitionHead = null;
        Node leftPartitionTail = null;
        Node rightPartitionTail = null;

        Node current = head;

        while (current != null) {

            Node newNode = new Node();
            newNode.data = current.data;

            if (current.data.compareTo(partition) < 0) {
                if (leftPartitionHead == null) {
                    leftPartitionHead = newNode;
                    leftPartitionTail = newNode;
                } else {
                    leftPartitionTail.next = newNode;
                    leftPartitionTail = leftPartitionTail.next;
                }
            } else {
                if (rightPartitionHead == null) {
                    rightPartitionHead = newNode;
                    rightPartitionTail = newNode;
                } else {
                    rightPartitionTail.next = newNode;
                    rightPartitionTail = rightPartitionTail.next;
                }
            }

            current = current.next;
        }

        if (leftPartitionHead == null) {
            head = rightPartitionHead;
            return head;
        }

        leftPartitionTail.next = rightPartitionHead;
        head = leftPartitionHead;
        return head;
    }
}

public class Node<T extends Comparable<T>> {

    public T data;

    public Node<T> next;
}


public class ListPartitionerTest {

    @Test
    public void partitionTest() {
        Node<Integer> head = new Node<Integer>();
        head.next = new Node<Integer>();
        head.next.next = new Node<Integer>();
        head.next.next.next = new Node<Integer>();
        head.next.next.next.next = new Node<Integer>();
        head.next.next.next.next.next = new Node<Integer>();

        head.data = 1;
        head.next.data = 4;
        head.next.next.data = 3;
        head.next.next.next.data = 2;
        head.next.next.next.next.data = 5;
        head.next.next.next.next.next.data = 2;

        ListPartitioner partitioner = new ListPartitioner();
        Node<Integer> result = partitioner.partition(head, 3);

        assertEquals(1, (int) result.data);
        assertEquals(2, (int) result.next.data);
        assertEquals(2, (int) result.next.next.data);
        assertEquals(4, (int) result.next.next.next.data);
        assertEquals(3, (int) result.next.next.next.next.data);
        assertEquals(5, (int) result.next.next.next.next.next.data);

    }
}