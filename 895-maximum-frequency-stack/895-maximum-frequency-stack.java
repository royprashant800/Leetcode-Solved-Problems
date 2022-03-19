class FreqStack {
    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> freqStack;
    int maxFreq;
    public FreqStack() {
        freqMap = new HashMap<>();
        freqStack = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int x) {
        int freq = freqMap.getOrDefault(x, 0) + 1;
        freqMap.put(x, freq);
        if(freq > maxFreq) maxFreq = freq;
        freqStack.computeIfAbsent(freq, f->new Stack()).push(x);
    }
    
    public int pop() {
        Stack<Integer> s = freqStack.get(maxFreq);
        int top = s.pop();
        if(s.isEmpty()) maxFreq--;
        freqMap.put(top, freqMap.get(top) - 1);
        return top;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */