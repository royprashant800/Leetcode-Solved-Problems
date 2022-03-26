class Solution {
    public int minSideJumps(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][4];
        for(int[] d : dp) Arrays.fill(d, -1);
        
        return helper(0, 2, n, nums, dp); 
    }
    private int helper(int i, int lane, int n, int[] nums, int[][] dp) {
        if((i < n - 1 && nums[i] == lane) || (i > 0 && nums[i - 1] == lane)) 
            return 1000000;
        
        if(i == n - 1) return 0;
        
        if(dp[i][lane] != -1) return dp[i][lane];
        
        int a = helper(i + 1, lane, n, nums, dp);
        int b = 0, c = 0;
        
        if(lane == 1) {
            b = 1 + helper(i + 1, 2, n, nums, dp);
            c = 1 + helper(i + 1, 3, n, nums, dp);
        } else if(lane == 2) {
            b = 1 + helper(i + 1, 1, n, nums, dp);
            c = 1 + helper(i + 1, 3, n, nums, dp);
        } else {
            b = 1 + helper(i + 1, 1, n, nums, dp);
            c = 1 + helper(i + 1, 2, n, nums, dp);
        }
        return dp[i][lane] = Math.min(a, Math.min(b, c));
    }
}