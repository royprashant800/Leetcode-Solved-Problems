class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;
        Integer[][] dp = new Integer[m + 1][10000];
        return rec(mat, 0, m, n, 0, target, dp); 
    }
    private int rec(int[][] mat, int idx, int m, int n, int sum, int target, Integer[][] dp) {
        if(idx == m)
            return Math.abs(target - sum);
        
        if(dp[idx][sum] != null)
            return dp[idx][sum];
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) 
            min = Math.min(min, rec(mat, idx + 1, m, n, sum + mat[idx][i], target, dp));
        
        return dp[idx][sum] = min;
    }
}