class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;
        Boolean[][] dp = new Boolean[n][sum/2 + 1];
        return solve(nums, 0, sum / 2, n, dp);
    }
    private static boolean solve(int[] nums, int i, int sum, int n, Boolean[][] dp) {
        if(sum == 0) return true;
        if(i >= n) return false;

        if(dp[i][sum] != null) return dp[i][sum];
        boolean take = false;
        if(nums[i] <= sum) take = solve(nums, i + 1, sum - nums[i], n, dp);
        boolean notake = solve(nums, i + 1, sum, n, dp);
        return dp[i][sum] = take | notake;
    }
}