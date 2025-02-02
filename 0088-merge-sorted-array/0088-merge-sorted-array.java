class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) nums1[k++] = nums1[i++];
            else {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp; 
                i++;k++;
                int l = 1;
                while(l < n && nums2[l] < nums2[l - 1]) {
                    swap(nums2, l, l - 1);
                    l++;
                }
            }
        }
        if(i < m) {
            while(i < m) nums1[k++] = nums1[i++];
        } 
        if(j < n) {
            while(j < n) nums1[k++] = nums2[j++];
        } 
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}