class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length, j = 0, k = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            j = i + 1;
            k = n - 1;
            while(j < k) {
                int curr = nums[i] + nums[j] + nums[k];
                if(curr == 0) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(temp);
                    j++;k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(k > j && nums[k] == nums[k + 1]) k--;
                } 
                else if(curr > 0) k--;
                else j++;
            }
        }
        return res;
    }
}