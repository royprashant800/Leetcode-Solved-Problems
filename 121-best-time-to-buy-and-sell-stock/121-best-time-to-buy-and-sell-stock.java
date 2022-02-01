class Solution {
    public int maxProfit(int[] prices) {
        
       int minPrice = prices[0], maxProfit = 0, n = prices.length;
		for(int i=1; i<n; i++) {
			if(prices[i] < minPrice) {
				minPrice = prices[i];
			}
			if(prices[i] - minPrice > maxProfit)
				maxProfit = prices[i] - minPrice;
		}
		return  maxProfit;
    }
}