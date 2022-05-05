class MyStack {
    Deque<Integer> stack1=new ArrayDeque<>();
    Deque<Integer> stack2=new ArrayDeque<>();
    int top=-1;
    public MyStack() {
        
    }
    
    public void push(int x) {
        stack1.add(x);
        top=x;
    }
    
    public int pop() {
        int ans=-1;
        while(stack1.size()>1){
            top=stack1.remove();
            stack2.add(top);
        }
        ans=stack1.remove();
        stack1=stack2;
        stack2=new ArrayDeque<>();
        return ans;
    }
    
    public int top() {
       return top;
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