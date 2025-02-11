class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;

        for(int i = n - 2; i >= 0; i--) {
            int res = (int)1E8;
            for(int j = i + 1; j <= Math.min(i + nums[i], n - 1); j++) {
                res = Math.min(res, 1 + dp[j]);
            }
            dp[i] = res;
        }
        return dp[0];
    }
}