class Solution {
    private final static int MOD = 1_000_000_007;

  public int rearrangeSticks(int n, int k) {
    if(k > n || k < 1) return 0;
    if(k == n) return 1;

    long[] dp = new long[k + 1];
    Arrays.fill(dp, 1);

    for(int i = 1; i + k <= n; i++){
      long[] dp2 = new long[k + 1];
      for(int j = 1; j <= k; j++){
        dp2[j] = (dp2[j-1]  + (i+j-1) * dp[j]) % MOD;
      }

      dp = dp2;
    }

    return (int)dp[k];
  }
}