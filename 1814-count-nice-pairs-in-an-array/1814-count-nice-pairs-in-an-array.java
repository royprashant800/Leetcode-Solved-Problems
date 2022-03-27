class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> rev = new HashMap<>();
        
        int res = 0, mod = 1000000007;
        for(int i : nums) {
            if(!rev.containsKey(i))
                rev.put(i, reverse(i));
            int diff = i - rev.get(i);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
            res += map.get(diff) - 1;
            res %= mod;
        }
        return res % mod;
    }
    private int reverse(int n) {
        int res = 0;
        while(n > 0) {
            res *= 10;
            res += (n % 10);
            n /= 10;
        }
        return res;
    }
}