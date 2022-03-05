class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int dp[] = nums.clone();
        int ans = dp[n-1];
        
        for(int i=n-2; i>=0; i--) {
            for(int j=i+1; j<n; j++) {
                if(Math.abs(nums[i] - nums[j]) != 1)
                    dp[i] = Math.max(dp[i], nums[i] + dp[j]);
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}