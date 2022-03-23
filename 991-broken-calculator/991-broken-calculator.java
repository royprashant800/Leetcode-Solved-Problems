class Solution {
    public int brokenCalc(int s, int t) {
        if(s > t) return s - t;
        
        int res = 0;
        while(t != s) {
            if(t < s || t % 2 != 0) t++;
            else if(t % 2 == 0) t /= 2;
            res++;
        }
        return res;
    }
}