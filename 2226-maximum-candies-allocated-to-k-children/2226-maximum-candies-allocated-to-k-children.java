class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int l = 1, r = candies[candies.length - 1], res = 0;
        
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(isPossible(candies, mid, k)) {
                res = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return res;
    }
    private boolean isPossible(int[] nums, int mid, long k) {
        long ct = 0;
        for(int i = 0; i < nums.length; i++) 
            ct += (int)(nums[i] / mid);
        return ct >= k;
    }
}