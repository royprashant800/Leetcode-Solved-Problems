class Solution {
    public int minimumWhiteTiles(String s, int nc, int len) {
        int n = s.length(), dp[][] = new int[n + 1][nc + 1];
        for(int i = 1; i <= n; ++i) {
            for(int k = 0; k <= nc; ++k) {
                int jump = dp[i - 1][k] + s.charAt(i - 1) - '0';
                int cover = k > 0 ? dp[Math.max(i - len, 0)][k - 1] : 1000;
                dp[i][k] = Math.min(cover, jump);
            }
        }
        return dp[n][nc];
    }
}