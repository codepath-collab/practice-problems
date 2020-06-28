class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            // two strings with different lengths are not isomorphic
            return false;
        }
        
        // mapping of characters from s to t
        Map<Character, Character> map = new HashMap<>();           
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if (map.containsKey(sChar) && map.get(sChar) != tChar) {
                // non-isomorphic if a character in s is mapped to more than one character in t
                return false;
            }
            
            if (!map.containsKey(sChar) && map.containsValue(tChar)) {
                // non-isomorphic if a character in t is mapped to more than one character in s
                return false;
            }
            
            map.put(sChar, tChar);
        }
        
        return true;
    }
}
