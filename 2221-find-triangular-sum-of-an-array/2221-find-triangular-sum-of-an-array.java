class Solution {
    public int triangularSum(int[] nums) {
        for(int i = nums.length; i > 0; i--) {
            for(int j = 1; j < i; j++) {
                nums[j - 1] += nums[j];
                nums[j - 1] %= 10;
            }
        }
        return nums[0];
    }
}