class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int sum = nums[i] + nums[j];
            if(sum == target) {
                res[0] = i + 1; 
                res[1] = j + 1;
                break;
            }
            if(sum > target) j--;
            else i++;
        }
        return res;
    }
}