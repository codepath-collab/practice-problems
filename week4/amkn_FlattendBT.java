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
    public void flatten(TreeNode root) {
    	ArrayList<Integer> l = new ArrayList<>();
	    getValue(root, l);

	    TreeNode current = root;
	    for (int i = 1; i < l.size(); i++) {
	        current.right = new TreeNode(l.get(i));
	        current.left = null;
	        current = current.right;
	    }
    }
    
    
    public void getValue(TreeNode root, ArrayList<Integer> l) {
	    if (root == null) { return; }
	    l.add(root.val);
	    getValue(root.left, l);
	    getValue(root.right, l);
    }
}
