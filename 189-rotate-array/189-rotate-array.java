class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k == 0 || k == n)
            return;
        k = k%n;
        
        reverse(nums, 0, n - 1 - k);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}