class MyQueue {
    // a helper stack
    private Stack<Integer> s1;
    // the queue in reverse order
    private Stack<Integer> s2;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        int val = 0;
	
	      while (!s2.isEmpty()) {
          // reverse the order of elements in the queue and put them in the helper stack
	        val = s2.pop();
	        s1.push(val);
	      }
	      
        // put the element to be added on the top of the helper stack
	      s1.push(x);

	      while (!s1.isEmpty()) {
          // reverse the order of elements in the helper stack and put them on the queue
	        val = s1.pop();
	        s2.push(val);
	      }	
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      // the element on the top of the helper stack is the first element in the queue
	    return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {	
      // the element on the top of the helper stack is the first element in the queue
	    return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (s2.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
