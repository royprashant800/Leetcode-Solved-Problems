class MyStack {
    Deque<Integer> q;
    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.addLast(x);
    }
    
    public int pop() {
        if(q.size() > 0) return q.removeLast();
        return -1;
    }
    
    public int top() {
        if(q.size() > 0) return q.peekLast();
        return -1;
    }
    
    public boolean empty() {
        return q.isEmpty();
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