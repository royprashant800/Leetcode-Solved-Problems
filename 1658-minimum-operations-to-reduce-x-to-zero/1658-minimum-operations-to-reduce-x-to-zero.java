class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length, sum = 0, res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) sum += i;
        if(x == sum) return n;
        
        int target = sum - x;
        sum = 0;
        
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(sum - target == 0)
                res = Math.max(res, i + 1);
            if(map.containsKey(sum - target))
                res = Math.max(res, i - map.get(sum - target));
            map.put(sum, i);
        }
        return res == -1 ? -1 : n - res;
    }
}