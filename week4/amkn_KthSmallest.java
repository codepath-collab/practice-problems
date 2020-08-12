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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
	    List<Integer> l = new ArrayList<>();
	    TreeNode current = root;

	    while (current != null || !s.isEmpty()) {

	        while (current != null) {
		        s.push(current);
		        current = current.left;
	        }

	        current = s.pop();
	        l.add(current.val);
	        current = current.right;
	    }

	    return l.get(k - 1);
    }
}
