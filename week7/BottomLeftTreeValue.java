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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    TreeNode toReturn = new TreeNode();
	
	    while (!q.isEmpty()) {
	        int size = q.size();
	        toReturn = q.poll();

	        if (toReturn.left != null) { q.add(toReturn.left); }
	        if (toReturn.right != null) { q.add(toReturn.right); }
	    
	        for (int i = 1; i < size; i++) {
		        TreeNode current = q.poll();

		        if (current.left != null) { q.add(current.left); }
		        if (current.right != null) { q.add(current.right); }
	        }
	    
	    }

	    return toReturn.val;
    }
}
