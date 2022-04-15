class FrontMiddleBackQueue {

    Deque<Integer> q;
    public FrontMiddleBackQueue() {
        q = new LinkedList<>();
    }
    
    public void pushFront(int val) {
        q.addFirst(val);
    }
    
    public void pushMiddle(int val) {
        int n = q.size();
        n = n / 2;
        List<Integer> li = new ArrayList<>();
        while(n-- > 0) {
            li.add(q.pollFirst());
        }
        q.addFirst(val);
        for(int i = li.size() - 1; i >= 0; i--) 
            q.addFirst(li.get(i));
    }
    
    public void pushBack(int val) {
        q.addLast(val);
    }
    
    public int popFront() {
        return q.isEmpty() == true ? -1 : q.pollFirst();
    }
    
    public int popMiddle() {
        int n = q.size();
        n = (n - 1) / 2;
        List<Integer> li = new ArrayList<>();
        while(n-- > 0) {
            li.add(q.pollFirst());
        }
        int res = q.isEmpty() == true ? -1 : q.pollFirst();
        for(int i = li.size() - 1; i >= 0; i--) 
            q.addFirst(li.get(i));
        return res;
    }
    
    public int popBack() {
        return q.isEmpty() == true ? -1 : q.pollLast();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */