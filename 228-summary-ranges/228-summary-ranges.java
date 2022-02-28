class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        
        for(int i = 0; i < n; i++) {
            int start = nums[i];
            while(i < n - 1 && nums[i] + 1 == nums[i + 1])
                i++;
            if(start == nums[i])
                res.add(String.valueOf(start));
            else
                res.add(start + "->" + nums[i]);
        }
        return res;
    }
}