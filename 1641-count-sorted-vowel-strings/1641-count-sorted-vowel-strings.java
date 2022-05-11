class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        
        for(int j=1; j<=n; j++)
            for(int i=1; i<5; i++)
                dp[i] = dp[i] + dp[i - 1];
        
        return dp[4];
    }
}