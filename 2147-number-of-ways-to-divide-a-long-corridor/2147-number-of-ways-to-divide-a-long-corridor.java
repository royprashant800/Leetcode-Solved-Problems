class Solution {
    int mod = 1000000007;
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        Integer[][] dp = new Integer[n + 1][3];
        return helper(0, 0, corridor, dp);
    }
    private int helper(int ind, int seats, String corridor, Integer[][] dp) {
        if(ind == corridor.length()) {
            if(seats == 2) return 1;
            return 0;
        }
        
        if(dp[ind][seats] != null)
            return dp[ind][seats]; 
        
        int calls = 0;
        if(seats == 2) {
            if(corridor.charAt(ind) == 'P') {
                calls += helper(ind + 1, 0, corridor, dp); 
                calls %= mod; 
                calls += helper(ind + 1, seats, corridor, dp);
                calls %= mod;
            } else {
                calls += helper(ind + 1, 1, corridor, dp);
                calls %= mod;
            }
        } else {
            calls += helper(ind + 1, seats + (corridor.charAt(ind) == 'S' ? 1 : 0), corridor, dp);
            calls %= mod;
        }
        return dp[ind][seats] = calls;
    }
}