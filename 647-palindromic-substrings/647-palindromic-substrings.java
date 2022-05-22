class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i=0; i<s.length(); i++) 
            res += helper(s, i, i) + helper(s, i, i+1);
        return res;
    }
    
    private int helper(String s, int i, int j) {
        if(i < 0 || j > s.length()-1)
            return 0;
        
        if(s.charAt(i) == s.charAt(j))
            return 1 + helper(s, i - 1, j + 1);
            
        return 0;
    }
}