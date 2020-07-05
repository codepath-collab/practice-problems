import java.util.*;

class Solution {

    // [73, 74, 75, 71, 69, 72, 76, 73]
    // i = 7, {}, 0
    // i = 6, {76}, 0
    // i = 5, {76, 72}, 1
    // i = 4, {76, 72, 69}, 1
    // i = 3, {76, 72, 71}, 2
    // i = 2, {
    public int[] dailyTemperatures(int[] T) {
	int len = T.length;
	int[] result = new int[len];
	Stack<Integer> temp = new Stack<>();
	
	for (int i = len - 1; i >= 0; i--) {
	    if (temp.isEmpty()) {
		result[i] = 0;
		temp.push(i);
	    }

	    while (!temp.isEmpty() && T[i] >= T[temp.peek()]) {
		temp.pop();
	    }

	    if (temp.isEmpty()) {
		result[i] = 0;
		temp.push(i);
	    } else {
		result[i] = temp.peek() - i;
		temp.push(i);
	    }
	    
	}

	return result;
    }
    
    public static void main(String[] args) {
	Solution s = new Solution();

        int[] T = new int[8];
	T[0] = 73;
	T[1] = 74;
	T[2] = 75;
	T[3] = 71;
	T[4] = 69;
	T[5] = 72;
	T[6] = 76;
	T[7] = 73;

	System.out.println(Arrays.toString(s.dailyTemperatures(T)));
    }
}
