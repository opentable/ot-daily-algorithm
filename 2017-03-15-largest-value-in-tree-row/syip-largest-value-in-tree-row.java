package largestvalueintreerow;
import java.util.*;
/**
 * @author syip
 * Find Largest Value in Each Tree Row
 * You need to find the largest value in each row of a binary tree.
 * Input:
 *          1
 *         / \
 *        3   2
 *       / \   \
 *      5   3   9
 * Output: [1, 3, 9]
 * 
 * Solution: Traverse tree, maintain highest value for each row O(n)
 */
public class LargestValueInTreeRow {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        Integer value;
        TreeNode(Integer value) {this.value = value;}
    }
    
    public static void getLargestValuesList(TreeNode root, Integer rowNumber, List<Integer> largestValuesList) {
        if (root == null) return;
        if (largestValuesList.size() <= rowNumber) {
            largestValuesList.add(rowNumber, root.value);
        } else if (largestValuesList.get(rowNumber) < root.value)
            largestValuesList.set(rowNumber, root.value);
        getLargestValuesList(root.left, rowNumber+1, largestValuesList);
        getLargestValuesList(root.right, rowNumber+1, largestValuesList);
    }
    
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        List<Integer> largestValues = new ArrayList<>();

        getLargestValuesList(treeNode, 0, largestValues);
        assert largestValues.equals(new ArrayList<Integer>(Arrays.asList(1)));
        
        largestValues = new ArrayList<>();
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(5);
        getLargestValuesList(treeNode, 0, largestValues);
        assert largestValues.equals(new ArrayList<Integer>(Arrays.asList(1, 3, 5)));
        
        largestValues = new ArrayList<>();
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(9);
        getLargestValuesList(treeNode, 0, largestValues);
        assert largestValues.equals(new ArrayList<Integer>(Arrays.asList(1, 3, 9)));
    }
}
