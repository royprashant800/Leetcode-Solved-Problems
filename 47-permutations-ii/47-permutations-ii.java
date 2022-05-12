class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        permutation(nums, res, 0, new ArrayList<>(), freq);
        return res;
    }
    static void permutation(int[] nums, List<List<Integer>> res, int ind, List<Integer> temp, boolean[] freq) {
        if(ind == nums.length) {
                if(!res.contains(temp)) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(!freq[i]) {
                freq[i] = true;
                temp.add(nums[i]);
                permutation(nums, res, ind+1, temp, freq);
                temp.remove(temp.size() - 1);    
                freq[i] = false;
            }
        }
    }
}