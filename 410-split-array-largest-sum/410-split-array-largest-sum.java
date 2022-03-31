class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int minVal = nums[0];
        int maxVal = 0;
        
        for(int i=0; i<n; i++) {
            minVal = Math.max(minVal, nums[i]);
            maxVal += nums[i];
        }
        while(minVal <= maxVal) {
            int midVal = minVal + (maxVal - minVal)/2;
            if(canSplit(midVal, nums, m))
                maxVal = midVal - 1;
            else
                minVal = midVal + 1;
        }
        return minVal;
    }
    private boolean canSplit(int maxSum, int[] nums, int m) {
        int currSum = 0;
        int splits = 1;
        for(int num : nums) {
            currSum += num;
            if(currSum > maxSum) {
                currSum = num;
                splits++;
                
                if(splits > m) 
                    return false;
            }
        }
        return true;
    }
}