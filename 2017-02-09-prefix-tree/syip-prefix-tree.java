package prefixtree;
import java.util.List;
import java.util.ArrayList;
/**
 * @author syip
 * # Implement Trie (Prefix Tree)
 * Implement a trie with insert, search, and startsWith methods.
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * Solution: Use array matching index to char, recursive traversal to generate 
 * all words matching startsWith
 */
public class PrefixTree {
    public static class Node {
        Node[] leaf;
        boolean endWord;
        public Node() { leaf = new Node[26]; }
    }
    public static class Trie {
        Node root;
        public Trie() { root = new Node(); }
        
        public void insert (String insertStr) {
            Node root = this.root;
            for (int i = 0; i < insertStr.length(); i++) {
                int charInt = insertStr.charAt(i) - 'a';
                if (root.leaf[charInt] == null) {
                    Node newLeaf = new Node();
                    root.leaf[charInt] = newLeaf;
                }
                root = root.leaf[charInt];
            }
            root.endWord = true;
        }
        public boolean search (String searchStr) {
            Node leaf = getLastLeaf(searchStr);
            if (leaf == null) return false;
            return (leaf.endWord);
        }
        public List<String> startsWith (String startStr) {
            List<String> curList = new ArrayList<>();
            Node leaf = getLastLeaf(startStr);
            if (leaf == null) return curList;
            curList.add(startStr);
            return getStringsFromNode(leaf, startStr);
        }
        private List<String> getStringsFromNode(Node node, String currentString) {
            List<String> allLeafStrings = new ArrayList<>();
            if (node.endWord) allLeafStrings.add(currentString);
            for (int i = 0; i < node.leaf.length; i++) {
                if (node.leaf[i] != null) {
                    char curChar = (char) (i + 'a');
                    String newPrefix = currentString + curChar;
                    allLeafStrings.addAll(getStringsFromNode(node.leaf[i], newPrefix));
                }
            }
            return allLeafStrings;
        }
        private Node getLastLeaf(String searchStr) {
            Node curNode = this.root;
            for (int i = 0; i < searchStr.length(); i++) {
                int charInt = searchStr.charAt(i)-'a';
                if (curNode.leaf[charInt] == null) return null;
                curNode = curNode.leaf[charInt];
            }
            return curNode;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("helloworld");
        trie.insert("hellocalifornia");
        trie.insert("hellohawaii");
        trie.insert("hellocali");
        assert trie.search("hello");
        assert trie.startsWith("helloc").size() == 2;
        assert trie.startsWith("h").size() == 5;
        assert trie.startsWith("hellohawaii").size() == 1;
        assert trie.startsWith("hellom").isEmpty();
        assert trie.startsWith("f").isEmpty();
    }
    
}
