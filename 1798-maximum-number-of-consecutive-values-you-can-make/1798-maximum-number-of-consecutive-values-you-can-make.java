class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        
        int res = 1;
        for(int c : coins) {
            if(c > res) break;
            res += c;
        }
        return res;
    }
}