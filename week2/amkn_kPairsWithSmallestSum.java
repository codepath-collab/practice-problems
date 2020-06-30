class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int queueSize = nums1.length*nums2.length;
        
        if (queueSize == 0) {
        	return new ArrayList<List<Integer>>();
        }
        
        
        if (k > queueSize) {
            k = queueSize;
        }
        
        Comparator<Pair> sumCompare = (Pair p1, Pair p2) -> (p1.getSum() - p2.getSum());
	PriorityQueue<Pair> sums = new PriorityQueue<>(queueSize, sumCompare);

	for (int i = 0; i < nums1.length; i++) {
		int current = nums1[i];
	        
          	for (int j = 0; j < nums2.length; j++) {
			sums.add(new Pair(current, nums2[j]));
	        }
	    }

	    List<List<Integer>> toReturn = new ArrayList<>();

	    for (int m = 0; m < k; m++) {
	        toReturn.add(sums.poll().getPair());
	    }

	    return toReturn;             
    }
}

class Pair {
    int u;
    int v;
    int sum;
    
    public Pair(int u, int v) {
	    this.u = u;
	    this.v = v;
	    this.sum = u + v;
    }

    public int getSum() {
	    return this.sum;
    }

    public List<Integer> getPair() {
	    List<Integer> toReturn = new ArrayList<>();
	    toReturn.add(this.u);
	    toReturn.add(this.v);
	    return toReturn;
    }
}
