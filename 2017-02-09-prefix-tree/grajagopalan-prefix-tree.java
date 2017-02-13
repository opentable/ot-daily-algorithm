public class Node
{
    public HashMap<Character, Node> children;

    public boolean isWordComplete;
}


public class Trie {

    private Node root = new Node();

    public void insert(String word) {
        if (root == null) {
            root = new Node();
        }

        Node prevReference = root;
        for(int index = 0; index < word.length(); index++) {
            boolean endOfWord = (index == word.length() -1) ? true: false;
            prevReference = insertChar(prevReference, word.charAt(index), endOfWord);
        }
    }

    public boolean search(String word) {
        Node current = root;
        for(int index = 0; index < word.length(); index++) {

            if (current.children == null) {
                return false;
            }

            if (current.children.containsKey(word.charAt(index))) {
                current = current.children.get(word.charAt(index));
                continue;
            }

            return false;
        }

        return current.isWordComplete;
    }

    private Node insertChar(Node reference, char c, boolean endOfWord) {

        if (reference.children == null) {
            reference.children = new HashMap<>();
        }

        if (reference.children.containsKey(c)) {
            if (endOfWord) {
                reference.children.get(c).isWordComplete = true;
            }

            return reference.children.get(c);
        }

        Node newChild = new Node();
        if (endOfWord) {
            newChild.isWordComplete = true;
        }

        reference.children.put(c, newChild);
        return reference.children.get(c);
    }
}

public class TrieTest {

    @Test
    public void basicTest() {

        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("car");
        trie.insert("cart");
        trie.insert("bat");
        trie.insert("bar");

        assertTrue(trie.search("car"));
        assertFalse(trie.search("carte"));
        assertTrue(trie.search("cat"));
        assertTrue(trie.search("cart"));
        assertTrue(trie.search("bar"));
        assertTrue(trie.search("bat"));
        assertFalse(trie.search("batt"));
        assertFalse(trie.search("bart"));

    }
}
