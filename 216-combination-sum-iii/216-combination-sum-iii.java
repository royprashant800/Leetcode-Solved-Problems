class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        sum(1, k, n, res, new ArrayList<Integer>());
        return res;
    }
    static void sum(int ind, int k, int n, List<List<Integer>> res, List<Integer> temp) {
        if(temp.size() == k) {
        	if(n == 0)
                res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=ind; i<=9; i++) {       		
            temp.add(i);
            sum(i + 1, k, n-i, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}