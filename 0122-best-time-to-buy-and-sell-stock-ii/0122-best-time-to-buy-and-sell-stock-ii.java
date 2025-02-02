class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return findProfit(1, prices, 0, dp);
    }
    private int findProfit(int buy, int[] prices, int i, Integer[][] dp) {
        if(i >= prices.length) return 0;
        if(dp[i][buy] != null) return dp[i][buy];

        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[i] + findProfit(0, prices, i + 1, dp), findProfit(1, prices, i + 1, dp));
        } else {
            profit = Math.max(prices[i] + findProfit(1, prices, i + 1, dp), findProfit(0, prices, i + 1, dp));
        }
        return dp[i][buy] = profit;
    }
}