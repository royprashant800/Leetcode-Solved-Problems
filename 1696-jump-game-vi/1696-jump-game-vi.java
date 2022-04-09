class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        pq.add(new int[]{nums[0], 0});
        int res = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            while(pq.peek()[1] < i - k) {
                pq.poll();
            }
            pq.add(new int[]{res = nums[i] + pq.peek()[0], i});
        }
        return res;
    }
}