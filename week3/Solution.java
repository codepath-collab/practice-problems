import java.util.*;

class Solution {

    // 2, -1, 1, -2
    // i = 0, {2}
    // i = 1, {2}
    // i = 2, {2, 1}
    // i = 3, {}
    public int[] asteroidCollision(int[] asteroids) {
	Stack<Integer> stable = new Stack<>();

	for (int i = 0; i < asteroids.length; i++) {
	    int current = asteroids[i];
	    
	    if (stable.isEmpty()) {
		stable.push(asteroids[i]);
	    } else if (stable.peek() > 0 && current < 0) {

		if (Math.abs(current) > Math.abs(stable.peek())) {
		    stable.pop();

		    boolean pushCurrent = true;

		    while (!stable.isEmpty() && stable.peek() > 0 && Math.abs(stable.peek()) <= Math.abs(current)) {
			int top = stable.pop();
			
			if (top + current == 0) {
			    pushCurrent = false;
			    break;
			} else {
			    pushCurrent = true;
			}
		    }

		    if (!stable.isEmpty() && stable.peek() > 0 && Math.abs(stable.peek()) > Math.abs(current)) {
			pushCurrent = false;
		    }

		    if (pushCurrent) {
			stable.push(current);
		    }
		    
		} else if (current + stable.peek() == 0) {
		    stable.pop();
		}
		
	    } else {
		stable.push(current);
	    }
	    
	}

	int size = stable.size();
	int[] ans = new int[size];

	if (size == 0) {
	    return ans;
	}

	for (int k = size - 1; k >= 0; k--) {
	    ans[k] = stable.pop();
	}

	return ans;
    }

    public static void main(String[] args) {
	Solution s = new Solution();

	// 5, 10
        int[] asteroids1 = new int[3];
	asteroids1[0] = 5;
	asteroids1[1] = 10;
	asteroids1[2] = -5;

	// []
	int[] asteroids2 = new int[2];
	asteroids2[0] = 8;
	asteroids2[1] = -8;

	// 10
	int[] asteroids3 = new int[3];
	asteroids3[0] = 10;
	asteroids3[1] = 2;
	asteroids3[2] = -5;

	// -2, -1, 1, 2
	int[] asteroids4 = new int[4];
	asteroids4[0] = -2;
	asteroids4[1] = -1;
	asteroids4[2] = 1;
	asteroids4[3] = 2;

	// -2
	int[] asteroids5 = new int[4];
	asteroids5[0] = -2;
	asteroids5[1] = 2;
	asteroids5[2] = 1;
	asteroids5[3] = -2;

	// - 2, -2
	int[] asteroids6 = new int[4];
	asteroids6[0] = 1;
	asteroids6[1] = 1;
	asteroids6[2] = -2;
	asteroids6[3] = -2;

	// 10, 1, 2, 10
	int[] asteroids7 = new int[10];
	asteroids7[0] = 10;
	asteroids7[1] = -8;
	asteroids7[2] = -9;
	asteroids7[3] = 1;
	asteroids7[4] = 8;
	asteroids7[5] = 8;
	asteroids7[6] = -9;
	asteroids7[7] = 1;
	asteroids7[8] = 2;
	asteroids7[9] = 10;

	// 1
	int[] asteroids8 = new int[4];
	asteroids8[0] = 1;
	asteroids8[1] = 2;
	asteroids8[2] = 1;
	asteroids8[3] = -2;

	//[]
	int[] asteroids9 = new int[4];
	asteroids9[0] = 2;
	asteroids9[1] = -1;
	asteroids9[2] = 1;
	asteroids9[3] = -2;
	
	System.out.println(Arrays.toString(s.asteroidCollision(asteroids1)));
	System.out.println(Arrays.toString(s.asteroidCollision(asteroids2)));
	System.out.println(Arrays.toString(s.asteroidCollision(asteroids3)));
	System.out.println(Arrays.toString(s.asteroidCollision(asteroids4)));
	System.out.println(Arrays.toString(s.asteroidCollision(asteroids5)));
	System.out.println(Arrays.toString(s.asteroidCollision(asteroids6)));
	System.out.println(Arrays.toString(s.asteroidCollision(asteroids7)));
	System.out.println(Arrays.toString(s.asteroidCollision(asteroids8)));
	System.out.println(Arrays.toString(s.asteroidCollision(asteroids9)));

    }
}
