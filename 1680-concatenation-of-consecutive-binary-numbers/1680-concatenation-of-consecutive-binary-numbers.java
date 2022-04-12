class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int mod = 1000000007;
        
        for(int i = 1; i <= n; i++) {
            String bs = Integer.toBinaryString(i);
            res = (res << bs.length()) % mod;
            res = (res + i) % mod;
        }
        return (int)res;
    }
}