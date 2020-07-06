class Solution {
    public String frequencySort(String s) {
      Map<Character, Integer> occurrences = new HashMap<>();

	    for (int i = 0; i < s.length(); i++) {
	        char current = s.charAt(i);
	        occurrences.put(current, occurrences.getOrDefault(current, 0) + 1);
	    }

	    Comparator<Character> byFrequency = (Character c1, Character c2) -> (occurrences.get(c2) - occurrences.get(c1));
	    Queue<Character> sortedFrequency = new PriorityQueue<>(byFrequency);

	    for (Character c: occurrences.keySet()) {
	        sortedFrequency.add(c);
	    }

	    StringBuilder sb = new StringBuilder();

	    while (!sortedFrequency.isEmpty()) {
	        char now = sortedFrequency.poll();
	        int num = occurrences.get(now);

	        while (num > 0) {
		        sb.append(now);
		        num--;
	        }
	    }

	    return sb.toString();   
    }
}
