class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        helper(nums, target, dp);
        return dp[target];
    }
    private int helper(int[] nums, int target, int[] dp) {
        if(dp[target] != -1)
            return dp[target];
        
        int res = 0;
        for(int i : nums) {
            if(i <= target) 
                res += helper(nums, target - i, dp);
        }
        return dp[target] = res;
    }
}