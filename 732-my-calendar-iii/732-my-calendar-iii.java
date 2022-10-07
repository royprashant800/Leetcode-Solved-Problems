class MyCalendarThree {
    Map<Integer, Integer> map;
    int res;
    public MyCalendarThree() {
        map = new TreeMap<>();
        res = 0;
    }
    
    public int book(int start, int end) {
        int temp = 0;
        
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        for(int it : map.values())
            res = Math.max(res, temp += it);
        
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */