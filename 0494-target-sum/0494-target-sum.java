class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum - target < 0 || (sum - target) % 2 == 1) return 0;
        return solve(nums, nums.length - 1, (sum - target) / 2);
    }
    private int solve(int[] nums, int n, int target) {
        if(n == 0) {
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || target == nums[0]) return 1;
            return 0;
        }

        int notTake = solve(nums, n - 1, target);
        int take = 0;
        if(nums[n] <= target) take = solve(nums, n - 1, target - nums[n]);
        return notTake + take;
    }
}