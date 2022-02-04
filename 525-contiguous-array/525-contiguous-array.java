class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length == 0 || nums == null) 
            return 0;
        for(int i=0; i<nums.length; i++)
            if(nums[i] == 0)
                nums[i] = -1;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0, max = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum)) {
                int last = map.get(sum);
                max = Math.max(max, i - last);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    } 
}