class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        int[] slotWt = new int[numSlots + 1];
        Map<String, Integer> dp = new HashMap<>();
        return helper(0, slotWt, nums, numSlots, dp);
    }
    private int helper(int ind, int[] slotWt, int[] nums, int numSlots, Map<String, Integer> dp) {
        if(ind >= nums.length) return 0;
        
        String s = "";
        s = s + ind + Arrays.toString(slotWt);            
        if(dp.containsKey(s)) return dp.get(s);
        
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= numSlots; i++) {
            if(slotWt[i] < 2) {
                slotWt[i]++;
                int res = (nums[ind] & i) + helper(ind + 1, slotWt, nums, numSlots, dp);
                slotWt[i]--;
                max = Math.max(max, res);
            }
        }
        dp.put(s, max);
        return max;
    }
}