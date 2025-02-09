class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length, res = 0;
        if(n == 1) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            int curr = time[i] % 60;
            if(curr == 0) res += map.getOrDefault(0, 0);
            else res += map.getOrDefault(60 - curr, 0);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return res;
    }
}