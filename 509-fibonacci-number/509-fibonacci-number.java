class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        return fibUtil(n, dp);
    }
    static int fibUtil(int n, int[] dp) {
        if(n <= 1) 
            return n;
        
        if(dp[n] != 0) 
            return dp[n];
        
        return dp[n] = fibUtil(n-1, dp) + fibUtil(n-2, dp);
    }
}