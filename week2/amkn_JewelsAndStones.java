class Solution {
    public int numJewelsInStones(String J, String S) {
        // a set for all characters in J
        Set<Character> jewels = new HashSet<>();
        char current = ' ';
        
        for (int i = 0; i < J.length(); i++) {
            current = J.charAt(i);
            jewels.add(current);
        }
        
        int count = 0;
        
        for (int j = 0; j < S.length(); j++) {
            current = S.charAt(j);
            
            if (jewels.contains(current)) {
                // increase the number of jewels if a character in J is also in S
                count++;
            }
        }
        
        return count;   
    }
}
