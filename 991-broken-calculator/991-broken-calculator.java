class Solution {
    public int brokenCalc(int s, int t) {        
        int res = 0;
        while(t > s) {
            if(t % 2 == 0) t /= 2;
            else t++;
            res++;
        }
        return res + (s - t); 
    }
}