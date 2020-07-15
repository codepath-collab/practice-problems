class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> _count = new HashMap<>();
	    List<List<String>> result = new ArrayList<>();
	
	    for (int i = 0; i < strs.length; i++) {
	        String current = strs[i];

	        char[] temp = current.toCharArray();
	        Arrays.sort(temp);
	        String sorted = new String(temp);

	        if (_count.containsKey(sorted)) {
		        _count.get(sorted).add(current);
	        } else {
		        List<String> group = new ArrayList<>();
		        group.add(current);
		        _count.put(sorted, group);
	        }
	    
	    }

        _count.forEach((k, v) -> result.add(v));

	    return result;
    }
}
