import java.util.*;

class Solution {
    
   public int maxSubArray(int[] nums) {
	  int startWithCurrent = 0;
	  int maxSoFar = Integer.MIN_VALUE;
	  int current = 0;

	  for (int i = 0; i < nums.length; i++) {
	    startWithCurrent = nums[i];
	    current += nums[i];

	    if (current < startWithCurrent) {
		    current = startWithCurrent;
	    }

	    maxSoFar = Math.max(maxSoFar, current);
	  }

	    return maxSoFar;
    }
    
    public static void main(String[] args) {
	    Solution s = new Solution();

	    int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
	    System.out.println(s.maxSubArray(nums));
	
    }
}
