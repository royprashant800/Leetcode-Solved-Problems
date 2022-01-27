class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, max = 0;
        for(int i=31; i>=0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums)
                set.add(mask & num);
            
            int temp = max | (1 << i);
            for(int prefix : set) {
                if(set.contains(temp ^ prefix)) {
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
}