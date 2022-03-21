class Solution {
    public int minimumWhiteTiles(String floor, int nc, int len) {
        int n = floor.length();
        int[] suffix = new int[n];
        Integer[][] dp = new Integer[n + 1][nc + 1];
        
        suffix[n - 1] = (floor.charAt(n - 1) == '1' ? 1 : 0);
        for(int i = n - 2; i >= 0; i--) 
            suffix[i] = suffix[i + 1] + (floor.charAt(i) == '1' ? 1 : 0);
        
        return helper(0, floor, nc, len, suffix, dp);
    }
    private int helper(int idx, String s, int nc, int len, int[] suffix, Integer[][] dp) {
        if(idx >= s.length()) return 0;
        else if(nc == 0) return suffix[idx];
        
        if(dp[idx][nc] != null) 
            return dp[idx][nc];
        
        int min1 = helper(idx + len, s, nc - 1, len, suffix, dp);
        int min2 = helper(idx + 1, s, nc, len, suffix, dp) + (s.charAt(idx) == '1' ? 1 : 0);
        return dp[idx][nc] = Math.min(min1, min2);
    }
}