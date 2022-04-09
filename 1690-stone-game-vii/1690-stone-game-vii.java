class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] preSum = new int[n + 1];
        Integer[][] dp = new Integer[n][n];
        
        for(int i = 0; i < n; i++)
            preSum[i + 1] = preSum[i] + stones[i];
        
        return helper(0, n - 1, preSum, dp);
    }
    private int helper(int left, int right, int[] preSum, Integer[][] dp) {
        if(left == right) return 0;
        
        if(dp[left][right] != null) return dp[left][right];
        
        int scoreRemLeft = getSum(preSum, left + 1, right);
        int scoreRemRight = getSum(preSum, left, right - 1);
        
        return dp[left][right] = Math.max(scoreRemLeft - helper(left + 1, right, preSum, dp), scoreRemRight - helper(left, right - 1, preSum, dp));
    }
    private int getSum(int[] preSum, int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}