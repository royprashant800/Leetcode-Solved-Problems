class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, l = 0, r = n - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[l]) {
                if((target >= nums[l] && target <= nums[mid])) r = mid - 1;
                else l = mid + 1;
            } else {
                if(target >= nums[mid] && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}