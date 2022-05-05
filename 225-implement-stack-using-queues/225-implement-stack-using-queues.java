class MyStack {
    Deque<Integer> stack1=new ArrayDeque<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        stack1.add(x);
        int size=stack1.size();
        while(size-->1){
            stack1.add(stack1.remove());
        }
    }
    
    public int pop() {
        return stack1.remove();
    }
    
    public int top() {
       return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */