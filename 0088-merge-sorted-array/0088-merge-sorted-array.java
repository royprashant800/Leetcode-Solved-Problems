class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) 
                i++;
            else {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i++;
                for(int k=1; k<n; k++) {
                    if(nums2[k] < nums2[k-1]) {
                        int num = nums2[k];
                        nums2[k] = nums2[k - 1];
                        nums2[k - 1] = num;
                    }
                }
            }
        }
        while(j < n) {
            nums1[i++] = nums2[j++];
        }
    }
}