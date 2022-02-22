class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int[][] dp = new int[14][20000];
        for(int[] a : dp)
            Arrays.fill(a, -1);
        
        return helper(0, 0, nums1, nums2, dp);
    }
    private int helper(int i, int mask, int[] nums1, int[] nums2, int[][] dp) {
        if(i == nums1.length) return 0;
        
        int res = Integer.MAX_VALUE;
        if(dp[i][mask] != -1) return dp[i][mask];
        
        for(int j = 0; j < nums2.length; j++)
            if((mask & (1 << j)) == 0)
               res = Math.min(res, (nums1[i] ^ nums2[j]) + helper(i + 1, (mask | (1 << j)), nums1, nums2, dp));
        
        return dp[i][mask] = res;                      
    }
}