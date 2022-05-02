class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        int res = 0;
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            int ct = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < n; j++) {
                sb.append(nums[j] + ",");
                if(nums[j] % p == 0)
                    ct++;
                if(ct > k) break;
                set.add(sb.toString());
            }
        }
        
        return set.size();
    }
}