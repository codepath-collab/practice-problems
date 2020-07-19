class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> result = new ArrayList<>();

	    int numRow = matrix.length;
      if (numRow == 0) { return result; }
	    int numCol = matrix[0].length;

	    int row = 0;
	    int col = 0;
	    int rowLowerLimit = 0;
	    int rowUpperLimit = numRow;  
	    int colLowerLimit = -1;
	    int colUpperLimit = numCol; 

	    while (result.size() < (numRow * numCol)) {

	        colUpperLimit--;
	        if (col <= colUpperLimit) {
		        while (col <= colUpperLimit) {
		            result.add(matrix[row][col]);
		            col++;
		        }

		        col--; 
		        row++;
	        } else {
		        break;
	        }
	    
	        rowUpperLimit--;
	        if (row <= rowUpperLimit) {
	        	while (row <= rowUpperLimit) {
		            result.add(matrix[row][col]);
		            row++;
		        }

		        row--;
		        col--;
	        } else {
		        break;
	        }

	        colLowerLimit++;
	        if (col >= colLowerLimit) {
		        while (col >= colLowerLimit) {
		            result.add(matrix[row][col]);
		            col--;
		        }
		        col++;
		        row--; 
	        } else {
		        break;
	        }
	    
	        rowLowerLimit++;
	        if (row >= rowLowerLimit) {
		        while (row >= rowLowerLimit) {
		            result.add(matrix[row][col]);
		            row--;
		        }
		        row++; 
		        col++;
	        } else {
		        break;
	        }
	    }
	
	    return result;
    }
}
