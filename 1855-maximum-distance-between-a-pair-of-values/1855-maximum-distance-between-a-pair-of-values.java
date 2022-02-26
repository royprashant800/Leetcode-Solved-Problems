class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int res = Integer.MIN_VALUE;
        
        for(int i = nums2.length - 1; i >= 0; i--) {
            int l = 0, r = Math.min(i, nums1.length - 1);
            while(l <= r) {
                int mid = (l + r)/2;
                if(nums1[mid] <= nums2[i]) {
                    res = Math.max(res, i - mid);
                    r = mid - 1;
                } 
                else l = mid + 1;
            }
        }
        return res < 0 ? 0 : res;
    }
}