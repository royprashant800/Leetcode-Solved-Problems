class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0, ones = 0, twos = 0, k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) zeros++;
            else if(nums[i] == 1) ones++;
            else twos++;
        }
        while(zeros-- > 0) nums[k++] = 0;
        while(ones-- > 0) nums[k++] = 1;
        while(twos-- > 0) nums[k++] = 2;
    }
}