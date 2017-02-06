/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otdaily;

/**
 *
 * @author mshah
 */
public class CheckBST {
    static Node root;
    public static void main(String[] args) {
        CheckBST btree = new CheckBST();
        root = new Node(5);
         if( btree.validateBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE) ) {
             System.out.println(" Valid BST");
         }
         else {
             System.out.println("Invalid BST");
         }
    }
    
    boolean validateBST(Node root, int max, int min) {
        if(root == null) {return true;}
        
        if(root.data < min || root.data > max) { return false;}
        
        return validateBST(root.left, root.data, min) && validateBST(root.right, max, root.data);
        
    }
    
}

class Node {
    Node left = null;
    Node right = null;
    int data;
    
    Node() {}
    
    Node(int d) {
        this.data = d;
    }
}
