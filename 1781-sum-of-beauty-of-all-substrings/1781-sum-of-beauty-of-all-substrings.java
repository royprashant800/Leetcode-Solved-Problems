class Solution {
    public int beautySum(String s) {
        int n = s.length(), res = 0;
        
        for(int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for(int j = i; j < n; j++) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                res += beauty(map);
            }
        }
            
        return res;
    }
    private int beauty(Map<Character, Integer> map) {
        int min = 500, max = 1;
        for(int i : map.values()) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        } 
        return Math.max(0, max - min);
    }
}