class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ss = "";
        
        for(int i = 0; i < n; i++) {
            String str = expand(s, i, i);
            if(str.length() > ss.length())
                ss = str;
            
            if(i < n - 1) 
                str = expand(s, i, i + 1);
            if(str.length() > ss.length())
                ss = str;
        }
        return ss;
    }
    private String expand(String s, int i, int j) {
        if(i == j) {
            i--;
            j++;
        }
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        } 
        return s.substring(i + 1, j);
    }
}