class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, n2 = n - k, sum = 0;
        for(int c : cardPoints) sum += c;

        int sum2 = 0;
        for(int i = 0; i < n2; i++) sum2 += cardPoints[i];
        int res = sum2;
        for(int i = n2; i < n; i++) {
            sum2 = sum2 + cardPoints[i] - cardPoints[i - n2];
            res = Math.min(res, sum2);
        }   
        return sum - res;
    }
}