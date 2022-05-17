class Solution {
    public int addRungs(int[] rungs, int dist) {
        int n = rungs.length;
        
        int res = 0, curr = 0;
        for(int i = 0; i < n; i++) {
            int diff = rungs[i] - curr;
            if(diff > dist) {
                int rung = diff / dist;
                res += (diff % dist == 0) ? rung - 1 : rung;
            }
            curr = rungs[i];
        }
        return res;
    }
}