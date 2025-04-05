class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }
    private static int solve(int[] nums, int ind, int xor) {
        if(ind == nums.length) return xor;

        return solve(nums, ind + 1, xor ^ nums[ind]) + solve(nums, ind + 1, xor);
    }
}