class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, zeros = 0;
        int[] res = new int[n];
        int product = 1;
        for(int num : nums) {
            if(num == 0) {
                zeros++;
                if(zeros > 1) {
                    product = 0;
                    break;
                }
                else continue;
            }
            product *= num;
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) res[i] = product;
            else if(zeros > 0) res[i] = 0; 
            else res[i] = product / nums[i];
        }
        return res;
    }
}