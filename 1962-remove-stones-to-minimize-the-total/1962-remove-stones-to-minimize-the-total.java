class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        
        int res = 0;
        for(int p : piles) {
            pq.add(p);
            res += p;
        }
        
        while(k-- > 0) {
            int num = pq.poll();
            pq.add(num - num / 2);
            res -= num / 2;
        }
        return res;
    }
}