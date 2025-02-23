class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, target, 0);
    }
    private int solve(int[] nums, int k, int target, int i) {
        if(i == nums.length && k == target) return 1;
        if(i >= nums.length) return 0;

        int a = solve(nums, k - nums[i], target, i + 1);
        int b = solve(nums, k + nums[i], target, i + 1);
        return a + b;
    }
}