class Solution {
    public int threeSumMulti(int[] nums, int t) {
        int n = nums.length, mod = 1000000007; 
        long res = 0;
        
        for(int i = 0; i < n; i++) {
            int[] count = new int[101];
            for(int j = i + 1; j < n; j++) {
                int k = t - nums[i] - nums[j]; 
                if(k >= 0 && k <= 100 && count[k] > 0) {
                    res += count[k];
                    res %= mod;
                }
                count[nums[j]]++;
            }
        }
        return (int)res;
    }
}