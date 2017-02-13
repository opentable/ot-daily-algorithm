public class BstValidator {

    public boolean isBST(Node head) {
        return isBSTInternal(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTInternal(Node head, int left, int right) {
        if (head == null) {
            return true;
        }

        if (head.data <= left || head.data >= right) {
            return false;
        }

        return isBSTInternal(head.left, left, head.data) &&
                isBSTInternal(head.right, head.data, right);
    }
}

public class BstValidatorTest {

    @Test
    public void isBST_invalid_Test() {
        Node root = new Node();
        root.left = new Node();
        root.left.left = new Node();
        root.left.right = new Node();
        root.right = new Node();
        root.right.left = new Node();

        root.data = 100;
        root.left.data = 90;
        root.right.data = 110;
        root.left.left.data = 80;
        root.left.right.data = 95;
        root.right.left.data = 85;

        assertFalse(new BstValidator().isBST(root));
    }


    @Test
    public void isBST_valid_Test() {
        Node root = new Node();
        root.left = new Node();
        root.left.left = new Node();
        root.left.right = new Node();
        root.right = new Node();
        root.right.left = new Node();

        root.data = 100;
        root.left.data = 90;
        root.right.data = 110;
        root.left.left.data = 80;
        root.left.right.data = 95;
        root.right.left.data = 105;

        assertTrue(new BstValidator().isBST(root));
    }
}
