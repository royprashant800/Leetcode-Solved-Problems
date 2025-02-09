class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, ind = -1, i = n - 2;
        if(i >= 0) {
            while(i >= 0 && nums[i] >= nums[i + 1]) i--; 
        }
        if(i >= 0) {
            for(int j = n - 1; j >= 0; j--) {
                if(nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }
        reverse(nums, i + 1);
    }
    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}