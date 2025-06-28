class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, j = 0;
		if(n <= 1) return nums;
		Deque<Integer> dq = new LinkedList<>();
		int ans[] = new int[n-k+1];
		
		for(int i = 0; i < n; i++) {
            if(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
            dq.addLast(i);
            if(i >= k - 1) ans[j++] = nums[dq.peekFirst()];
        }
		
		return ans;
    }
}