class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];
        return minJumps(nums, 0, n, dp);
    }
    private int minJumps(int[] nums, int i ,int n, Integer[] dp) {
        if(i >= n) return (int)1E8;
        if(i == n - 1) return 0;

        if(dp[i] != null) return dp[i]; 

        int res = (int)1E8;
        for(int j = i + 1; j <= Math.min(i + nums[i], n - 1); j++) {
            res = Math.min(res, 1 + minJumps(nums, j, n, dp));
        }
        return dp[i] = res;
    }
}