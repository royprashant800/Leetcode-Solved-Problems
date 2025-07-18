class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length/3;
        long res = Long.MAX_VALUE;
        long minSum = 0, maxSum = 0;
        
        PriorityQueue<Integer> maxq = new PriorityQueue<>((a, b) -> (nums[b] - nums[a]));
        PriorityQueue<Integer> minq = new PriorityQueue<>((a, b) -> (nums[a] - nums[b]));
        
        for(int i = 0; i < n; i++) {
            maxq.add(i);
            minSum += nums[i];
        }
        for(int i = 3 * n - 1; i >= 2 * n; i--) {
            minq.add(i);
            maxSum += nums[i];
        }
        
        long[] left = new long[n + 1];
        long[] right = new long[n + 1];
        left[0] = minSum;
        right[n] = maxSum;
        
        for(int i = n; i < 2 * n; i++) {
            if(nums[i] < nums[maxq.peek()]) {
                minSum = minSum - nums[maxq.poll()] + nums[i];
                maxq.add(i);
            }
            left[i - n + 1] = minSum;
        }
        for(int i = 2 * n - 1; i >= n; i--) {
            if(nums[i] > nums[minq.peek()]) {
                maxSum = maxSum - nums[minq.poll()] + nums[i];
                minq.add(i);
            }
            right[i - n] = maxSum;
        }
        
        for(int i = 0; i <= n; i++)
            res = Math.min(res, left[i] - right[i]);
        
        return res;
    }
}