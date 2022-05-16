class Solution {
    public int largestCombination(int[] candidates) {
        int res = 0, cur = 0;
        for(int i = 1; i < 10000000; i <<= 1) {
            cur = 0;
            for(int c : candidates)
                if((c & i) > 0)
                    cur++;
            res = Math.max(res, cur);
        }
        return res;
    }
}