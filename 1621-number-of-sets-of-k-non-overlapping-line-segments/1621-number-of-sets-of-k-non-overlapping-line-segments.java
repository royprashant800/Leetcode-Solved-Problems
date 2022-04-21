class Solution {
    int mod = 1000000007;
    public int numberOfSets(int n, int k) {
        Integer[][] dp = new Integer[n + 1][k + 1];
        return helper(n, k, dp);
    }
    private int helper(int n, int k, Integer[][] dp) {
        if(k == 0 || n - 1 == k) return 1;
        
        if(dp[n][k] != null) return dp[n][k];
        
        long sum = 0;
        sum += helper(n - 1, k, dp);
        for(int i = n - 1; i >= k; i--)
            sum += helper(i, k - 1, dp);
        
        sum %= mod;
        
        return dp[n][k] = (int)sum;
    }
}