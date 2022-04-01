class Solution {
    public void reverseString(char[] s) {
        int st = 0, end = s.length - 1;
        reverse(s, st, end);
    }
    static void reverse(char[] s, int st, int end) {
        if(st >= end) {
            return; 
        }
        
        char temp = s[st];
        s[st] = s[end];
        s[end] = temp;
        reverse(s, st + 1, end - 1);
    }
}