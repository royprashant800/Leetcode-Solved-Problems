class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
		sameDiff(n, k, 0, new ArrayList<>(), ans);
		
		int[] arr = new int[ans.size()];
		for(int i=0; i<ans.size(); i++) {
			arr[i] = ans.get(i);
		}
        return arr;
    }
    
    static void sameDiff(int n, int k, int ind, List<Integer> temp, List<Integer> ans) {
		if(temp.size() == n) {
			ans.add(toInt(temp));
			return;
		}
		
		for(int i=(ind == 0 ? 1 : 0); i<=9; i++) {
			if(temp.size() == 0) {
				temp.add(i);
				sameDiff(n, k, i + 1, temp, ans);
				temp.remove(temp.size()-1);								
			} else if(Math.abs(temp.get(temp.size()-1) - i) == k) {
				temp.add(i);
				sameDiff(n, k, i + 1, temp ,ans);
				temp.remove(temp.size()-1);				
			}
		}
	}
	static int toInt(List<Integer> res) {
		int val = 0, n = res.size();
		for(int i=0; i<n; i++) {
			val += Math.pow(10, n-1-i)*res.get(i);
		}
		return val;
	}
}