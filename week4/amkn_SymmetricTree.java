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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) { return true; }
	    return isSymmetricHelper(root.left, root.right);
    }
    
    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
	    if (left == null && right == null) { return true; }
	    if (left == null || right == null) { return false; }
	    if (left.val != right.val) { return false; }
	    if (left.left == null && right.right != null) { return false; }
	    if (left.left != null && right.right == null) { return false; }
	    if (left.right == null && right.left != null) { return false; }
	    if (left.right != null && right.left == null) { return false; }
	    return (isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left));
    }
}
