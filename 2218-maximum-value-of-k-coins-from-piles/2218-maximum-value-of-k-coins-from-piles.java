class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        
        return helper(0, k, piles, dp);
    }
    private int helper(int ind, int k, List<List<Integer>> piles, int[][] dp) {
        if(ind == piles.size() || k == 0) return 0;
        
        if(dp[ind][k] != -1) return dp[ind][k];
        
        int best = helper(ind + 1, k, piles, dp);
        int sum = 0;
        
        for(int i = 0; i < Math.min(k, piles.get(ind).size()); i++) {
            sum += piles.get(ind).get(i);
            best = Math.max(best, sum + helper(ind + 1, k - (i + 1), piles, dp));
        }
        return dp[ind][k] = best;
    }
}