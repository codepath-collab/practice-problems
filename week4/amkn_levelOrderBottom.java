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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

	    if (root == null) {
	        return ans;
	    }

	    Queue<TreeNode> currentLevel = new LinkedList<>();
	    currentLevel.add(root);

	    while (!currentLevel.isEmpty()) {
	        List<Integer> thisLevel = new ArrayList<>();

	        int nums = currentLevel.size();

	        for (int i = 0; i < nums; i++) {
		        TreeNode current = currentLevel.poll();
		        thisLevel.add(current.val);

		        if (current.left != null) {
		            currentLevel.add(current.left);
		        }

		        if (current.right != null) {
		            currentLevel.add(current.right);
		        }
	        }

	        ans.add(0, thisLevel);
	    
	    }

	    return ans;
    }
    
}
