import java.util.*;

class Solution {

  public int[][] sortInterval(int[][] nums) {
	  ArrayList<ArrayList<Integer>> a = new ArrayList<>();

	  for (int i = 0; i < nums.length; i++) {
	    ArrayList<Integer> l = new ArrayList<>();
	    for (int j = 0; j < 2; j++) {
		    l.add(nums[i][j]);
	    }
	    a.add(l);
	  }

	  a.sort((ArrayList<Integer> l1, ArrayList<Integer> l2) -> {
		  if (l1.get(0) == l2.get(0)) {
		    return l1.get(1) - l2.get(1);
		  }

		  return l1.get(0) - l2.get(0);
	  });

	  int k = 0;

	  while (k < a.size() - 1) {
	    if (a.get(k + 1).get(0) <= a.get(k).get(1)) {
		    ArrayList<Integer> n = new ArrayList<>();
		    n.add(a.get(k).get(0));
		    n.add(Math.max(a.get(k + 1).get(1), a.get(k).get(1)));
	      a.remove(k);
	      a.remove(k);
		    a.add(k, n);
	    } else {
		    k++;
	    }
	  }

	  int numRow = a.size();
	  int numCol = 2;
	  int[][] result = new int[numRow][numCol];

	  for (int i = 0; i < numRow; i++) {
	    ArrayList<Integer> current = a.get(i);
	    result[i][0] = current.get(0);
	    result[i][1] = current.get(1);
	  }

	  return result;
  }

  public void printResult(int[][] n) {
	  for (int i = 0; i < n.length; i++) {
	    for (int j = 0; j < n[0].length; j++) {
		    System.out.print(n[i][j] + " ");
	    }
	    System.out.println("");
	  }
  }
    
  public static void main(String[] args) {
	  Solution s = new Solution();

	  int[][] i1 = { {1, 4}, {2, 5}, {7, 9} };
	  s.printResult(s.sortInterval(i1));

	  int[][] i2 = { {6, 7}, {2, 4}, {5, 9} };
	  s.printResult(s.sortInterval(i2));

	  int[][] i3 = { {1, 4}, {2, 6}, {3, 5} };
	  s.printResult(s.sortInterval(i3));
  
  }
}
