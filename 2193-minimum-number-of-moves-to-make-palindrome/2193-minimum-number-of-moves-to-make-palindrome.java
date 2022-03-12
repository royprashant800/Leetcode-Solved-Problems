class Solution {
    public int minMovesToMakePalindrome(String str) {
        char[] s = str.toCharArray();
        int n = str.length();
        int l = 0, r = n - 1;
        int res = 0;
        
        while(l < r) {
            int rr = r;
            if(s[l] == s[rr]) {
                l++;
                r--;
                continue;
            }
            
            while(s[l] != s[rr]) {
                rr--;
            }
            if(l == rr) {
                swap(s, l, l + 1);
                res++;
            } else {
                while(rr != r) {
                    swap(s, rr, rr + 1);
                    rr++;
                    res++;
                }
            }   
        }
        return res;
    }
    private void swap(char[] s, int i, int j) {
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }
}