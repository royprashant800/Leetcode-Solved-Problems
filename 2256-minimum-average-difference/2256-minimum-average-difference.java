class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int[] res = new int[n];
        
        long sum1 = nums[0], sum2 = 0;
        for(int i = 1; i < n; i++) sum2 += nums[i];
        
        for(int i = 0; i < n; i++) {
            long left, right;
            
            if(i == 0) {
                left = sum1;
                right = sum2 / (n - 1 - i);
                res[i] = (int)Math.abs(left - right);
            } else if(i == n - 1) {
                sum1 += (long)nums[i];
                left = sum1 / (i + 1);
                res[i] = (int)left;
            } else {
                sum1 += (long)nums[i];
                sum2 -= (long)nums[i];
                left = sum1 / (i + 1);
                right = sum2 / (n - 1 - i);
                res[i] = (int)Math.abs(left - right);
            }
        }
        
        int index  = 0, val = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(res[i] < val) {
                index = i;
                val = res[i];
            }
        }
        return index;
    }
}