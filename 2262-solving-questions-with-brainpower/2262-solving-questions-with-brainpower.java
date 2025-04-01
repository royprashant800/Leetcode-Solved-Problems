class Solution {
    public long mostPoints(int[][] q) {
        int n = q.length;
        Long[] dp = new Long[n];
        return helper(q, 0, n, dp);
    }
    private long helper(int[][] q, int idx, int n, Long[] dp) {
        if(idx == n - 1)
            return new Long(q[idx][0]);
        if(idx >= n)
            return 0;
        if(dp[idx] != null)
            return dp[idx];
        
        long select = q[idx][0] + helper(q, idx + q[idx][1] + 1, n, dp);
        long ignore = 0 + helper(q, idx + 1, n, dp);
        return dp[idx] = Math.max(select, ignore);
    }
}