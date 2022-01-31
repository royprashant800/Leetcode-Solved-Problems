class Solution {
    long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long odds = n/2;
        long evens = n/2 + n%2;
        return (int)((power(4, odds) * power(5, evens))%MOD);
    }
    private long power(long x, long y) {
        if(y == 0) return 1;
        long ans = power(x, y/2);
        ans *= ans;
        ans %= MOD;
        if(y%2 == 1)
            ans *= x;
        ans %= MOD;
        return ans;
    }
}