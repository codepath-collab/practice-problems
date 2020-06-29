class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> unique = new HashMap<>();

	    for (String w : words) {
          // put the words and their frequency into a map
	        unique.put(w, unique.getOrDefault(w, 0) + 1);
	    }

	    List<String> toSort = new ArrayList<>(unique.keySet());

      // sort the list
      // if two strings are the same, they are sorted by alphabetical order; otherwise, they are sorted by their frequencies
	    Comparator<String> compareByFrequency = (String s1, String s2) -> (unique.get(s1) == unique.get(s2)) ? s1.compareTo(s2) : unique.get(s2) - unique.get(s1);

	    Collections.sort(toSort, compareByFrequency);

      // return top K words
	    return toSort.subList(0, k);
    }
}
