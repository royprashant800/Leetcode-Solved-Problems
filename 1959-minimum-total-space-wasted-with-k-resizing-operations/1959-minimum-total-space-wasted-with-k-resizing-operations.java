class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;
        Integer[][] dp = new Integer[k + 1][n];
        return dfs(nums, k, 0, dp);
    }
    private int dfs(int[] nums, int k, int i, Integer[][] dp) {
        int n = nums.length;
        
        if(dp[k][i] != null)
            return dp[k][i];
        
        dp[k][i] = Integer.MAX_VALUE;
        
        int max = nums[i];
        int sum = 0;
        for(int j=i; j<n; j++) {
            max = Math.max(max, nums[j]);
            sum += nums[j];
            int wasted = max * (j - i + 1) - sum;
            if(j == n - 1) 
                dp[k][i] = Math.min(dp[k][i], wasted);
            if(j < n - 1 && k > 0)
                dp[k][i] = Math.min(dp[k][i], wasted + dfs(nums, k - 1, j + 1, dp));
        }
        return dp[k][i];
    }
}