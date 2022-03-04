class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int max = 0;
        long sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum + k < nums[i] * (i - start + 1)) {
                sum -= nums[start];
                start++;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}