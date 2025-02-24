class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findSubsets(nums, res, 0, new ArrayList<>());
        return res;
    }
    private void findSubsets(int[] nums, List<List<Integer>> res, int i, List<Integer> temp) {
        if(i == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        findSubsets(nums, res, i + 1, temp);
        temp.add(nums[i]);
        findSubsets(nums, res, i + 1, temp);
        temp.remove(temp.size() - 1);
    }
}