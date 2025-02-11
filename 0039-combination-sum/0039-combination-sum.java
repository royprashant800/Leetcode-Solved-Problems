class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    private void solve(int[] nums, int k, int i, List<Integer> curr, List<List<Integer>> res) {
        if(k == 0) {
            if(!res.contains(curr)) res.add(new ArrayList<>(curr));
            return;
        }
        if(i >= nums.length || k < 0) return;

        curr.add(nums[i]);
        solve(nums, k - nums[i], i, curr, res);
        curr.remove(curr.size() - 1);
        solve(nums, k, i + 1, curr, res);
    }
}