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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

	    if (root == null) { return result; }

	    Stack<TreeNode> nums = new Stack<>();
	    TreeNode current = root;
	
	    while (current != null || !nums.isEmpty()) {

	        while (current != null) {
		        nums.push(current);
		        current = current.left;
	        }

	        current = nums.pop();
	        result.add(current.val);
	    
	        current = current.right;
	    }
	
	    return result;
    }
}
