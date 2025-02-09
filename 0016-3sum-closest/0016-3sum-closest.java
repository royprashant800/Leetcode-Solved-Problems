class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, res = 0, min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int curr = Math.abs(target - sum);
                if(sum == target) return sum; 
                if(curr < min) {
                    min = curr;
                    res = sum;
                } 
                if(sum < target) j++;
                if(sum > target) k--;
            }
        }
        return res;
    }
}