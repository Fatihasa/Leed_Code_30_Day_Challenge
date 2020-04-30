/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    int diameter;
    
    //diameter is the total number of longest distance using edges in the tree
    int printInorder(TreeNode node) 
    { 
        //base case for recursion
        if (node == null) 
            return -1; 
        int left = 0;
        int right = 0;
  
        /* Recursion for left children*/
        left = printInorder(node.left) + 1;
        
  
        /* current nodes value*/
        System.out.print(node.val + " "); 
  
        /* Recursion for right children*/
        right = printInorder(node.right) + 1; 
        
        //updates highest distance for current node
        if (diameter < (left + right))
            diameter = left + right;
        
        //retuns the longest left or right braches
        return Math.max(left, right);
    }
 
  
    // Wrappers for recursive function
    int diameterOfBinaryTree(TreeNode root) { 
        this.diameter = 0;
        printInorder(root);
        return this.diameter;
    } 
}
