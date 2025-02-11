class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int k = j + 1, l = n - 1;
                while(k < l) {
                    long curr = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
                    if(curr == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;l--;
                        while(k < l && nums[k] == nums[k - 1]) k++; 
                        while(k < l && nums[l] == nums[l + 1]) l--; 
                    } 
                    else if(curr > target) l--;
                    else k++;
                }
                while(j < n - 1 && nums[j] == nums[j + 1]) j++;
            }
            while(i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}