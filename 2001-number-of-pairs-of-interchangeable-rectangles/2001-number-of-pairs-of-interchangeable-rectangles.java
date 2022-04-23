class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        int n = rectangles.length;
        long res = 0;
        
        Map<Double, Integer> map = new HashMap<>();
        
        for(int i = n - 1; i >= 0; i--) {
            double key= (double)rectangles[i][0] / (double)rectangles[i][1];
            if(map.get(key) != null) 
                res += (long)map.get(key);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return res;
    }
}