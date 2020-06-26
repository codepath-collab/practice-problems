class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            // return true if both sequences are empty
            return true;
        }
        
        if (pushed.length != popped.length) {
            // return false if the length of both sequences are different
            // because each push is associated with each pop
            return false;
        }
        
        Stack<Integer> nums = new Stack<>();
        
        int i = 0, j = 0;
        
        while ((i == 0 && j == 0) || !nums.isEmpty() || (i < pushed.length && j < popped.length)) {
          // start looping on the first iteration or when the stack is non-empty or we have not reached the end of any of the sequences
	        if (i == pushed.length) {
            // ensure we access valid elements in the array
		        i--;
	        }

	        if (j == popped.length) {
            // ensure we access valid elements in the array
		        j--;
	        }
	        
          // element to push
	        int toPush = pushed[i];
          // element to pop
	        int toPop = popped[j];
            
            if (nums.isEmpty()) {
              // push an element if the stack is empty and there are still elements available for pushing
		          nums.push(toPush);
		          i++;
            } else if (nums.peek() == toPop) {
              // pop element if this is a valid pop
              nums.pop();
              j++;
            } else if (nums.search(toPop) != -1) {
              // return false when the element to pop is in the stack but not on the top of the stack
              return false;
            } else {
              // pushing elements if there are still elements available for pushing
              nums.push(toPush);
              i++;
            }
        }
       
        return true;
    }
}
