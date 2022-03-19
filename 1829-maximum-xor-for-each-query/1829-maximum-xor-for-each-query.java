class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] res = new int[n];
        int max = (int)Math.pow(2, maximumBit) -1 , ans = 0;
        
        for(int i = 0; i < n; i++) {
            ans ^= nums[i];
            res[n - 1 - i] = max ^ ans;
        }
        return res;
    }
}