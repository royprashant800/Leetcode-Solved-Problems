class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        if(n == 1) return 1;
        int i = 0, j = n - 1;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;j--;
            } else if(i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                i++;
            } else if(j < n - 1 && s.charAt(j) == s.charAt(j + 1)) {
                j--;
            } else {
                break;
            }
        }
        if(i == j) {
            if(s.charAt(i + 1) != s.charAt(i)) return 1;
            else return 0;
        }
        return j - i + 1;
    }
}