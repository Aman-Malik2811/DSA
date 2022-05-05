class MyStack {
    Deque<Integer> stack=new ArrayDeque<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        stack.addLast(x);
    }
    
    public int pop() {
        return stack.removeLast();
    }
    
    public int top() {
       return stack.getLast();
    }
    
    public boolean empty() {
        return stack.isEmpty();
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