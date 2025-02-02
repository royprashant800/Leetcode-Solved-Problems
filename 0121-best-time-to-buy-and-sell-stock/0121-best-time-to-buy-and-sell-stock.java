class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, profit = 0, n = prices.length;

        for(int i = 0; i < n; i++) {
            if(prices[i] < buy) buy = prices[i];
            else profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }
}