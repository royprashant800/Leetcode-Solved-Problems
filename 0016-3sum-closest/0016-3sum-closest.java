class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, res = 0, min = Integer.MAX_VALUE;
       
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(Math.abs(target - sum) < min) {
                        res = sum;
                        min = Math.abs(target - sum);
                    }
                }
            }
        }
        return res;
    }
}