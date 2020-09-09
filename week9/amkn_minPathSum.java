class Solution {
    public int minPathSum(int[][] grid) {
	    int[][] sum = new int[grid.length][grid[0].length];
	    sum[0][0] = grid[0][0];

	    for (int row = 0; row < grid.length; row++) {
	        for (int col = 0; col < grid[0].length; col++) {
		        if (row > 0) {
		            if (col == 0) {
			            sum[row][col] = sum[row - 1][col] + grid[row][col];
		            } else {
			            sum[row][col] = Math.min(sum[row - 1][col], sum[row][col - 1]) + grid[row][col];
		            }
		        } else {
		            if (col > 0) {
			            sum[row][col] = sum[row][col - 1] + grid[row][col];
		            }
		        }
	        }
	    }

	    return sum[grid.length - 1][grid[0].length - 1];
    }
 
}
