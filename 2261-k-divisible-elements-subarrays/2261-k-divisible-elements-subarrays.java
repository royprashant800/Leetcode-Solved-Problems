class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        int res = 0;
        Set<List<Integer>> set = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            int ct = 0;
            List<Integer> li = new ArrayList<>();
            for(int j = i; j < n; j++) {
                li.add(nums[j]);
                if(nums[j] % p == 0)
                    ct++;
                if(ct <= k) {
                    res++;
                    set.add(new ArrayList<>(li));
                }
                else break;
            }
        }
        
        return set.size();
    }
}