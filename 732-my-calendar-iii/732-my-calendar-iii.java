class MyCalendarThree {
    Map<Integer, Integer> map;
    int res;
    public MyCalendarThree() {
        map = new TreeMap<>();
        res = 0;
    }
    
    public int book(int start, int end) {
        int temp = 0;
        
        Integer val = map.get(start);
        map.put(start, val == null ? 1 : val + 1);
        val = map.get(end);
        map.put(end, val == null ? -1 : val - 1);
        
        for(Map.Entry<Integer, Integer> it : map.entrySet())
            res = Math.max(res, temp += it.getValue());
        
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */