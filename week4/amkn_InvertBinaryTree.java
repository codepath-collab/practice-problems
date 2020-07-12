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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) { return null; }
	    Queue<TreeNode> level = new LinkedList<>();
	    level.add(root);
	
    	while (level.size() > 0) {
	        TreeNode current = level.poll();

	        TreeNode temp = current.left;
	        current.left = current.right;
	        current.right = temp;

	        if (current.left != null) { level.add(current.left); }
	        if (current.right != null) { level.add(current.right); }
	    }

	    return root;
    }
}
