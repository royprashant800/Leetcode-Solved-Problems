class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] seen = new int[100_001]; 
        
        int left = 0, right = 0;
        int maxScore = 0, currScore = 0;
        
        while (right < n) {
            seen[nums[right]]++;
            currScore += nums[right];
            // Keep moving left pointer until we get rid of duplicate element
            while (right < n && seen[nums[right]] > 1) {
                seen[nums[left]]--;
                currScore -= nums[left];
                left++;
            }
            // Save best score
            maxScore = Math.max(maxScore, currScore);
            right++;
        }
        return maxScore;
    }
}