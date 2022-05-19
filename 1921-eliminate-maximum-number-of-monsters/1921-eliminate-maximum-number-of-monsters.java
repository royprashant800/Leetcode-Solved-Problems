class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[][] nums = new int[n][3];
    
        for(int i = 0; i < n; i++) {
            nums[i][0] = dist[i];
            nums[i][1] = speed[i];
            nums[i][2] = dist[i] % speed[i] == 0 ? dist[i] / speed[i] : (dist[i] + speed[i]) / speed[i];
        }
        Arrays.sort(nums, (a, b) -> (a[2] - b[2]));
        int res = 0;
        for(int i = 0; i < n; i++) {
            long num = res * nums[i][1];
            if((long)nums[i][0] - num > 0) res++;
            else break;
        }
        return res;
    }
}