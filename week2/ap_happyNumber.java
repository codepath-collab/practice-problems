// runtime: 1ms
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> allValues = new HashSet<Integer>();
        int[] squaredValues = new int[10];
        int counter = 0, value = 0, sum = n, checkRepeat = 0;
        
        // Filling in the squaredValues array with the square value for 
        // each value 0 - 9 [0][1][4][9][16][25][36][42][64][81]
        for (int i = 0; i < squaredValues.length; i++) {
            squaredValues[i] = i * i;
        }
        
        // Edge case: accounting for single digit values 
        if (sum < 10) 
            sum = squaredValues[sum];
            
        // As long as the sum isn't resulting in 1, then we call the function
        // storing the values in a hashset to ensure 
        // number calculations aren't repeated
        while (sum != 1) {
            if (allValues.contains(sum))
                return false;
            allValues.add(sum);
            sum = calculateHappyNumber(sum, squaredValues);
        }
        
        return true;
    }
    
    public int calculateHappyNumber (int sum, int[] squares) {
        String happyNumber = String.valueOf(sum);
        int counter = 0, value = 0, total = 0, length = happyNumber.length();
        
        // For the length of the string:
        while (counter < length) {
            // calculating the value at each index of the string 
            value = Character.getNumericValue(happyNumber.charAt(counter));
            total += squares[value];
            counter++;
        }
        return total;
    }
}
