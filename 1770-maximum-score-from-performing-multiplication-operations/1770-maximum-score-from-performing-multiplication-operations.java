class Solution {
    public int maximumScore(int[] nums, int[] mul) {
        int n = nums.length, m = mul.length;
        int[][] dp = new int[m + 1][m + 1];
    
        for(int i = m - 1; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                int s1 = (nums[j] * mul[i]) + dp[i + 1][j + 1];
                int s2 = (nums[n - 1 - (i - j)] * mul[i]) + dp[i + 1][j];
                dp[i][j] = Math.max(s1, s2);
            }
        }
        return dp[0][0];
    }
}