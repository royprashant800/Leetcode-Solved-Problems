class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
    
        for(int i = 0; i < n; i++) {
            int num = dist[i] / speed[i];
            dist[i] = dist[i] % speed[i] == 0 ? num : num + 1;
        }
        Arrays.sort(dist);
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(dist[i] - res > 0) res++;
            else return i;
        }
        return n;
    }
}