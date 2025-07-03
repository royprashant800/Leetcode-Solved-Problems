class StockSpanner {
    List<Integer> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        int n = list.size();
        int res = 1;
        for(int i = n - 1; i >= 0; i--) {
            if(list.get(i) <= price) {
                res++;
                continue;
            }
            else break;
        }
        list.add(price);
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */