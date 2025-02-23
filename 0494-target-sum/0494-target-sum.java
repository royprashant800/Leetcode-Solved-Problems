class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>(); 
        return solve(nums, 0, target, 0, dp);
    }
    private int solve(int[] nums, int k, int target, int i, Map<String, Integer> dp) {
        if(i == nums.length && k == target) return 1;
        if(i >= nums.length) return 0;

        String s = i + "*" + k;
        if(dp.get(s) != null) return dp.get(s);

        int a = solve(nums, k - nums[i], target, i + 1, dp);
        int b = solve(nums, k + nums[i], target, i + 1, dp);
        dp.put(s, a + b);
        return a + b;
    }
}