class Solution {
    public int maxScore(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i<k; i++)
            sum += nums[i];
        
        int max = sum;
        for(int i=k - 1; i>=0; i--) {
            sum = sum - nums[i] + nums[nums.length + i - k];
            max = Math.max(max, sum);
        }
        return max;            
    }
}