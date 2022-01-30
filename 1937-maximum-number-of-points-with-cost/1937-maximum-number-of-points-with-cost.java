class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length, m = points[0].length;
        long[] prev = new long[m];
        long res = Long.MIN_VALUE;
        
        for(int i=0; i<m; i++)
            prev[i] = points[0][i];
        for(int i=1; i<n; i++) {
            long[] dp = new long[m];
            long left = 0;
            for(int j=0; j<m; j++) {
                long temp = Math.max(prev[j], left - 1);
                dp[j] = temp + points[i][j];
                left = temp;
            }
            long right = 0;
            for(int j=m-1; j>=0; j--) {
                long temp = Math.max(prev[j], right - 1);
                dp[j] = Math.max(dp[j], temp + points[i][j]);
                right = temp;
                prev[j] = dp[j];
            }
        }
        res = Arrays.stream(prev).max().getAsLong();
        return res;
    }
}