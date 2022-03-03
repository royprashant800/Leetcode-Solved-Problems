class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        nums[0] = 1;
        
        for(int i = 1; i < n; i++) {
            int num = Math.abs(nums[i] - nums[i - 1]);
            if(num > 1)
                nums[i] = nums[i - 1] + 1;
        }
        return nums[n - 1];
    }
}