class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n % 2 != 0) return new int[]{};
        
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) 
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        
        int[] res = new int[n/2];
        int i = 0;
        
        for(int x : map.keySet()) {
            if(map.get(x) > map.getOrDefault(x + x, 0))
                return new int[]{};
            
            for(int j = 0; j < map.get(x); j++) {
                res[i++] = x;
                map.put(x + x, map.get(x + x) - 1);
            }
        }
        return res;
    }
}