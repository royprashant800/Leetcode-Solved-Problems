class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];
        return checkJump(nums, n, 0, dp);
    }
    private boolean checkJump(int[] nums, int n, int i, Boolean[] dp) {
        if(i == n - 1) return true;
        if(i >= n) return false;
        
        if(dp[i] != null) return dp[i];

        boolean res = false;
        for(int j = i + 1; j <= Math.min(i + nums[i], n - 1); j++) {
            if(checkJump(nums, n, j, dp)) res = true;
        }
        return dp[i] = res;
    }
}