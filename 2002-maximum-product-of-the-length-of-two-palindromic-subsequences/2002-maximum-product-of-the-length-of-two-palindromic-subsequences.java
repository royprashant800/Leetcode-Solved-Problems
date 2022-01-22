class Solution {
    int ans = 0;
    public int maxProduct(String s) {
        solve(s, "", "", 0);
        return ans;
    }
    private void solve(String s, String s1, String s2, int st) {
        if(st == s.length()) {
            if(isPal(s1) && isPal(s2)) {
                int val = s1.length() * s2.length();
                ans = Math.max(ans, val);
            }
            return;
        }
        
        char ch = s.charAt(st);
        solve(s, s1 + ch, s2, st + 1);
        solve(s, s1, s2 + ch, st + 1);
        solve(s, s1, s2, st + 1);
    }
    private boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
}