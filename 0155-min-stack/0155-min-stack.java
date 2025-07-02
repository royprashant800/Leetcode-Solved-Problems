class MinStack {

    Stack<Integer> stack;
    TreeMap<Integer, Integer> map;
    public MinStack() {
        stack = new Stack<>();
        map = new TreeMap<>();
    }
    
    public void push(int val) {
        stack.push(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
    }
    
    public void pop() {
        int val = stack.pop();
        int freq = map.get(val);
        if(freq > 1) map.put(val, map.getOrDefault(val, 0) - 1);
        else map.remove(val);
    }
    
    public int top() {
        int val = stack.peek();
        return val;
    }
    
    public int getMin() {
        return map.firstKey();
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