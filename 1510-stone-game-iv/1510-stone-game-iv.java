class Solution {
    Boolean[] dp = new Boolean[100005];
    public boolean winnerSquareGame(int n) {
        if(dp[n] != null) return dp[n];
        if(n == 0) return false;
        boolean winner = false;
        for(int i=1; i*i<=n; i++) {
            if(!winnerSquareGame(n - i*i)) {
                winner = true;
                break;
            }
        }
        return dp[n] = winner;
    }
}