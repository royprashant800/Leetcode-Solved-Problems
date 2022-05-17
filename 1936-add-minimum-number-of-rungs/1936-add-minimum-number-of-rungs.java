class Solution {
    public int addRungs(int[] rungs, int dist) {
        int res = 0, curr = 0;
        for(int r : rungs) {
            res += (r - curr - 1) / dist;
            curr = r;
        }
        return res;
    }
}