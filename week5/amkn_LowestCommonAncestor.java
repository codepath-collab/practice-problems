/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) { return root; }
	    boolean isPLeft = containsNode(root.left, p);
	    boolean isQLeft = containsNode(root.left, q);

	    if (isPLeft && isQLeft) {
	        return lowestCommonAncestor(root.left, p, q);
	    }

	    if (!isPLeft && !isQLeft) {
	        return lowestCommonAncestor(root.right, p, q);
	    }

	    return root;
    }
    
    
    public boolean containsNode(TreeNode root, TreeNode p) {
	    if (root == null) { return false; }
	    if (root.val == p.val) { return true; }
	    return (containsNode(root.left, p) || containsNode(root.right, p));
    }
}
