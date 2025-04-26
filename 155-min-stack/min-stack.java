class MinStack {
int mn = Integer.MAX_VALUE;
Stack<Integer>stack = new Stack<>();
    // public MinStack() {
        
    // }
    
    public void push(int val) {
        if(val<=mn){
            stack.push(mn);
            mn = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop()==mn){
            mn = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mn;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */