class Solution {
    public boolean validMountainArray(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;
        
        int i;
        for(i=1; i<n; i++) {
            if(nums[i] > nums[i - 1]) continue;
            else if(nums[i] == nums[i - 1])
                return false;
            else
                break;
        }
        if(i == 1 || i == n) return false;
        for(int j=i; j<n; j++) {
            if(nums[j] < nums[j - 1]) continue;
            else
                return false;
        }
        return true;
    }
}