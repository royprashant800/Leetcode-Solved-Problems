class Solution {
    public long numberOfWays(String s) {
        long one = 0, zero = 0, oneZero = 0, zeroOne = 0, ways = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                zero++;
                oneZero += one;
                ways += zeroOne;
            } else {
                one++;
                zeroOne += zero;
                ways += oneZero;
            }
        }
        return ways;
    }
}