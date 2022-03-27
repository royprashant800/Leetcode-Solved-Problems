class Solution {
    public int minDeletion(int[] nums) {
        int del = 0, n = nums.length;
        
        for(int i = 0; i < n; ) {
            int idx = i - del;
            if((idx % 2 == 0) && i < n - 1 && nums[i] == nums[i + 1]) del++;
            else i++;
        } 
        return ((n - del) % 2 == 0) ? del : del + 1;
    }
}