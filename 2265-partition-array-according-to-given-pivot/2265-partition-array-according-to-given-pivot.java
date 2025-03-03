class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        
        int ct = 0, j = 0;;
        for(int i = 0; i < n; i++) {
            if(nums[i] < pivot)
                res[j++] = nums[i];
            if(nums[i] == pivot)
                ct++;
        }
        for(int i = 0; i < ct; i++)
            res[j++] = pivot;
        
        for(int i = 0; i < n; i++)
            if(nums[i] > pivot)
                res[j++] = nums[i];
        
        return res;
    }
}