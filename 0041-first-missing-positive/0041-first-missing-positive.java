class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            max = Math.max(max, num);
            set.add(num);
        }
        
        int missing = 0, i;
        for(i=1; i<=max; i++) {
            if(!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing == 0 ? i : missing;
    }
}