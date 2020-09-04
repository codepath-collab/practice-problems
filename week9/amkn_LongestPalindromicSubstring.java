class Solution {
    public String longestPalindrome(String s) {
      String result = "";
	    int maxLen = 0;

	    for (int i = 0; i < s.length(); i++) {
	        for (int j = i + 1; j < s.length(); j++) {

		    if ((j - i) > maxLen && isPalindrome(s, i, j - 1)) {
		        maxLen = j - i;
		        result = s.substring(i, j);
		    }
		
	    }

	        if ((s.length() - i) > maxLen && isPalindrome(s, i, s.length() - 1)) {
		        maxLen = s.length() - i;
		        result = s.substring(i);
	        }
	    }

	    return result;
    }
    
     
    public boolean isPalindrome(String s, int start, int end) {
	    if (start >= end) { return true; }
	    if (s.charAt(start) == s.charAt(end)) {
	        return isPalindrome(s, start + 1, end - 1);
	    }
	    return false;
    }
}
