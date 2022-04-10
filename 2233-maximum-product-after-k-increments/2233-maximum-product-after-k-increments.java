class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int mod = 1000000007;
        for(int n : nums) pq.add(n);
        
        for(int i = 0; i < k; i++) {
            int num = pq.poll() + 1;
            pq.add(num);
        }
        long res = 1;
        while(!pq.isEmpty()) {
            res *= pq.poll();
            res %= mod;
        }
        return (int)res;
    }
}