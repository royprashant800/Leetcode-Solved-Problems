class Solution {
    public int getMaximumConsecutive(int[] coins) {
        int[] ct = new int[40001];
        for(int c : coins) ct[c]++;
        
        int res = 1;
        for(int i = 1; i < ct.length && i <= res; i++)
            res += (i * ct[i]);
        return res;
    }
}