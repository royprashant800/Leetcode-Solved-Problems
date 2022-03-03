class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int res = 0;
        
        for(int i=2; i<nums.length; i++) {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                count++;
            } else {
                res += count * (count+1)/2;
                count = 0;
            }
        }
        return res + count * (count+1)/2;
    }
}