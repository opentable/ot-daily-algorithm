import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mshah
 */
/*
Tree
      1

     / \

    2   3

   / \   \  
   
  4   5   9 
Output 1 3 9
*/
public class Largestvalueintreerow {
    static TNode root; 
    //A simple bfs would suffice keeping track of max at each level
    public static void main(String[] args) {
        Largestvalueintreerow tree = new Largestvalueintreerow();
        tree.root = new TNode(1);
        tree.root.left = new TNode(2);
        tree.root.right = new TNode(3);
        tree.root.left.left = new TNode(4);
        tree.root.left.right = new TNode(5);
        tree.root.right.right = new TNode(9);
        
        tree.findLargest(root);
    }
    
    void findLargest(TNode root) {
        if(root == null) {
            return;
        }
        
        //Create a BFS queue to perform level order traversal
        Queue<TNode> bfs = new LinkedList();
        bfs.add(root);
        TNode level = new TNode();
        bfs.add(level);
        //Added the first root node and a special node to mark the end of level
        
        //Max datastruct keeps track of max value at each level
        int max = root.data;
        while(bfs.size()>0) {
            TNode current = bfs.remove();
            if(current == level) {
                //Marks the end of each level and prints the Max
                System.out.print(" " + max);
                max = Integer.MIN_VALUE;
                if(bfs.size()>0)
                    bfs.add(level);
            } else {
                if(max<current.data) {
                    max = current.data;
                }
                //Add remaining nodes for the current parent
                if(current.left!=null)
                    bfs.add(current.left);
                if(current.right!=null)
                    bfs.add(current.right);
            }
            
        }
        System.out.println("");
    }
}

class TNode {
    TNode left = null;
    TNode right = null;
    int data;
    
    TNode(int d) {
        this.data = d;
    }
    
    TNode() {}
}
