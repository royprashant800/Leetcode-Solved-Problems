class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0, l = 1;
        
        for(int num : nums) {
            if(num > l) {
                long r = Math.min(num - 1, l + k - 1);
                int ct = (int)(r - l + 1);
                res += (l + r) * ct / 2;
                k -= ct;
                if(k == 0)
                    return res;
            }
            l = num + 1;
        }
        if(k > 0)
            res += (l + l + k - 1) * k / 2;
        return res;
    }
}