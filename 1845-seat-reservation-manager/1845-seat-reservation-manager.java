class SeatManager {
    int n;
    PriorityQueue<Integer> pq;
    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        this.n = n;
        for(int i = 1; i <= n; i++)
            pq.add(i);
    }
    
    public int reserve() {
        return pq.poll();
    }
    
    public void unreserve(int i) {
        pq.add(i);
    }
}