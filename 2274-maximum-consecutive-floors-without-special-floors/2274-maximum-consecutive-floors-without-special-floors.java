class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int n = special.length;
        Arrays.sort(special);
        
        int res = 0;
        res = Math.max(res, Math.max(special[0] - bottom, top - special[n - 1]));
        if(n == 1) return res;
        
        for(int i = 1; i < n; i++) 
            res = Math.max(res, special[i] - special[i - 1] - 1);
        
        return res;
    }
}