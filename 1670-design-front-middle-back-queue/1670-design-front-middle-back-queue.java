class FrontMiddleBackQueue {
    List<Integer> li;
    public FrontMiddleBackQueue() {
        li = new ArrayList<>();
    }
    
    public void pushFront(int val) {
        li.add(0, val);
    }
    
    public void pushMiddle(int val) {
        li.add(li.size() / 2, val);
    }
    
    public void pushBack(int val) {
        li.add(val);
    }
    
    public int popFront() {
        return li.isEmpty() ? -1 : li.remove(0);
    }
    
    public int popMiddle() {
        return li.isEmpty() ? -1 : li.remove((li.size() - 1) / 2);
    }
    
    public int popBack() {
        return li.isEmpty() ? -1 : li.remove(li.size() - 1);
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