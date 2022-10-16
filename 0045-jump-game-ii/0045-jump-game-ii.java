class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];
        return solve(nums, 0, n, dp);
    }
    
	static int solve(int[] arr, int ind, int n, Integer[] dp) {
		if(ind == n - 1)
			return 0;
        
        if(dp[ind] != null)
            return dp[ind];
		
		int min = (int)1e9;
		for(int i = ind + 1; i <= Math.min(ind + arr[ind], n - 1); i++) {
			int jumps = 1 + solve(arr, i, n, dp);
			min = Math.min(jumps, min);
		}
		return dp[ind] = min;
	}
}