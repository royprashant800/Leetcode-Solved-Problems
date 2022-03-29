class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 2;
        while(l <= r) {
            int mid = (l + r) >> 1;
            if(nums[mid] == nums[mid ^ 1])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return nums[l];
    }
}