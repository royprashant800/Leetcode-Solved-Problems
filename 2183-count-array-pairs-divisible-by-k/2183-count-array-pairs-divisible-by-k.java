class Solution {
    public long countPairs(int[] nums, int k) {
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int gcd = findGcd(nums[i], k);
            for(int num : map.keySet()) {
                if((long) gcd * num % k == 0)
                    res += map.get(num);
            }
            map.put(gcd, map.getOrDefault(gcd, 0) + 1);
        }
        return res;
    }
    private int findGcd(int x, int y) {
        if(x < y) return findGcd(y, x);
        return y == 0 ? x : findGcd(y, x % y);
    }
}