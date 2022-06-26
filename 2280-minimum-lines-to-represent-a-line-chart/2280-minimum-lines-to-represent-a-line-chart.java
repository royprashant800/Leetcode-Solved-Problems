class Solution {
    public int minimumLines(int[][] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        Arrays.sort(nums, (a, b) -> (a[0] - b[0]));
        int res = 1;
        
        for(int i = 1; i < n - 1; i++) {
            if(1L * (nums[i][1] - nums[i - 1][1]) * (nums[i + 1][0] - nums[i][0]) != 1L * (nums[i + 1][1] - nums[i][1]) * (nums[i][0] - nums[i - 1][0]))
                res++;
        }
        return res;
    }
}