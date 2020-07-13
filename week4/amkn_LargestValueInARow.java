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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

	    if (root == null) { return result; }
	
	    Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	
        while (q.size() > 0) {
	        int size = q.size(); 
	        TreeNode current = q.poll(); 
	        if (current.left != null) { q.add(current.left); } 
	        if (current.right != null) { q.add(current.right); }
	    
	        int max = current.val;
	    
	        for (int i = 1; i < size; i++) {
		        current = q.poll();
		        max = Math.max(current.val, max);
		        if (current.left != null) { q.add(current.left); }
		        if (current.right != null) { q.add(current.right); }
	        }

	        result.add(max);
	    }

	    return result;
    }
}
