class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1];
        
        for(int i = 0; i < n; i++)
            f[nums[i]]++;
        for(int i = 0; i < n; i++)
            if(f[i] == 0)
                return i;
        return n;
    }
}