class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int p : piles) pq.add(p);
        
        while(k > 0) {
            int num = pq.poll();
            pq.add(num - num / 2);
            k--;
        }
        int res = 0;
        while(!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }
}