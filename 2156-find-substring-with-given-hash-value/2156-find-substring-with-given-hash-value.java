class Solution {
    public String subStrHash(String s, int p, int m, int k, int h) {
        int n = s.length();
        long hash = 0;
        int ind = n;
        long pr = 1;
        for(int i = n - 1; i >= 0; i--) {
            hash = ((hash * p)%m + (s.charAt(i) - 'a' + 1))%m;
            
            if(i + k >= n) {
                pr = (pr * p)%m;
            } else {
                hash = (hash - ((s.charAt(i + k) - 'a' + 1) * pr)%m + m)%m;
            }
            if(hash == h)
                ind = i;
        }
        return s.substring(ind, ind + k);
    }
}