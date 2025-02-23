class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, n = nums.length;
        for(int num : nums) sum += num;
        if(sum - target < 0 || (sum - target) % 2 == 1) return 0;
        int s2 = (sum - target) / 2;
        int[][] dp = new int[n][s2 + 1];

        if(nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if(nums[0] != 0 && nums[0] <= s2) dp[0][nums[0]] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= s2; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if(nums[i] <= j) take = dp[i - 1][j - nums[i]];
                dp[i][j] = notTake + take;
            }
        }
        return dp[n - 1][s2];
    }
}