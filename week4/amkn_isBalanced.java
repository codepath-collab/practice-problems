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
    public boolean isBalanced(TreeNode root) {
        if (root == null) { return true; }
	    if (root.left == null && root.right == null) { return true; }
        if (root.left == null) { return (isBalancedHelper(root.right) == 1); }
	    if (root.right == null) { return (isBalancedHelper(root.left) == 1); }
            
	    int left = isBalancedHelper(root.left);
	    int right = isBalancedHelper(root.right);
	
	    if (Math.abs(left - right) > 1) {
	        return false;
	    }

	    return (isBalanced(root.left) && isBalanced(root.right));
    }
    
    public int isBalancedHelper(TreeNode root) {
	    if (root == null) { return 0; }
	    if (root.left == null && root.right == null) { return 1; }
	    if (root.left == null) { return 1 + isBalancedHelper(root.right); }
	    if (root.right == null) { return 1 + isBalancedHelper(root.left); }
	    return Math.max(1 + isBalancedHelper(root.left), 1 + isBalancedHelper(root.right));
    }

}
