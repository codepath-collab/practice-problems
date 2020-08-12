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
    public boolean isValidBST(TreeNode root) {
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

	    for (int i = 0; i < l.size() - 1; i++) {
	        if (l.get(i) >= l.get(i + 1)) {
		        return false;
	        }
	    }

	    return true;
    }
}
