class Solution {
    public int lastStoneWeight(int[] nums) {
        if(nums.length == 1) return nums[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int n : nums) pq.add(n);
        
        while(pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            if(num2 < num1) {
                pq.add(num1 - num2);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}