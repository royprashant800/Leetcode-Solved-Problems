class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tasks)
            map.put(t, map.getOrDefault(t, 0) + 1);
        
        int res = 0;
        for(int v : map.values()) {
            if(v == 1) return -1;
            res += v % 3 == 0 ? v / 3 : 1 + v / 3;
        }
        return res;
    }
}