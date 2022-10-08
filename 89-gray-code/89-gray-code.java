class Solution {
    public List<Integer> grayCode(int n) {
        List<String> temp = gray(n);
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<temp.size(); i++) {
            res.add(Integer.parseInt(temp.get(i), 2));
        }
        return res;
    }
    static List<String> gray(int n) {
        if(n == 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add("0");
            base.add("1");
            return base;
        }
        
        List<String> tempAns = gray(n-1);
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<tempAns.size(); i++) {
            String str = tempAns.get(i);
            ans.add("0" + str);
        }
        for(int i=tempAns.size()-1; i>=0; i--) {
            String str = tempAns.get(i);
            ans.add("1" + str);
        }
        return ans;
    }
}