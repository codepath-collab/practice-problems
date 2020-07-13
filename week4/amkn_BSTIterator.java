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
class BSTIterator {
    
    ArrayList<Integer> nums;
    int i;
    
    public BSTIterator(TreeNode root) {
        nums = new ArrayList<>();
	    i = 0;
	    buildTree(root, 0);
    }
    
    private void buildTree(TreeNode root, int k) {
        if (root == null) { return; }
        
	    nums.add(k, root.val);

	    if (root.left != null) {
	        buildTree(root.left, k);
	    }

	    if (root.right != null) {
	        buildTree(root.right, nums.indexOf(root.val) + 1);
	    }
	
    }
    
    /** @return the next smallest number */
    public int next() {
        return (nums.get(i++));
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (nums.size() == 0) { return false; }
	    return  (i < nums.size());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
