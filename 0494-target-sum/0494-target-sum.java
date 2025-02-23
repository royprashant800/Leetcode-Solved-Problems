class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, n = nums.length;
        for(int num : nums) sum += num;
        if(sum - target < 0 || (sum - target) % 2 == 1) return 0;
        int s2 = (sum - target) / 2;
        Integer[][] dp = new Integer[n][s2 + 1];
        return solve(nums, n - 1, s2, dp);
    }
    private int solve(int[] nums, int n, int target, Integer[][] dp) {
        if(n == 0) {
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || target == nums[0]) return 1;
            return 0;
        }

        if(dp[n][target] != null) return dp[n][target];

        int notTake = solve(nums, n - 1, target, dp);
        int take = 0;
        if(nums[n] <= target) take = solve(nums, n - 1, target - nums[n], dp);
        return dp[n][target] = notTake + take;
    }
}