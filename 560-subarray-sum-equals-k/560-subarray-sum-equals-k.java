class Solution {
    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int left__to_right_sum = 0;
        int count = 0;
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            left__to_right_sum += nums[i];
            if(map.containsKey(left__to_right_sum - k)) count += map.get(left__to_right_sum - k);
            map.put(left__to_right_sum, map.getOrDefault(left__to_right_sum, 0) + 1);
        }
        return count;
    }
}