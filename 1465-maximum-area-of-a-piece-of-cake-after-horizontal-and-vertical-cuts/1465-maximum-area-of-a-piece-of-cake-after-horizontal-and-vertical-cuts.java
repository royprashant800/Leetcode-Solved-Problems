class Solution {
    public int maxArea(int ht, int wd, int[] h, int[] v) {
        Arrays.sort(h);
        Arrays.sort(v);
        
        int maxh = Math.max(h[0] - 0,  ht - h[h.length - 1]);
        for(int i=1; i<h.length; i++) {
            
            maxh = Math.max(maxh, h[i] - h[i - 1]);
        }
        
        int maxv = Math.max(v[0] - 0,  wd - v[v.length - 1]);
        for(int i=1; i<v.length; i++) {
            
            maxv = Math.max(maxv, v[i] - v[i - 1]);
        }
        long res = 1L * maxh * maxv;
        return (int)(res%1000000007);
    }
}