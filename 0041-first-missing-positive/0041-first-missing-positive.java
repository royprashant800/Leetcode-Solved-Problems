class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int max = n + 1;
        for(int num : nums) {
            max = Math.max(num, max);
            set.add(num);
        }

        for(int i = 1; i <= max; i++) {
            if(!set.contains(i)) return i;
        }
        return -1;
    }
}