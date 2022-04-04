class Solution {
    public int[][] highestPeak(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        int[][] res = new int[m][n];
        for(int[] a : res) Arrays.fill(a, -1);
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(nums[i][j] == 1) {
                    res[i][j] = 0;
                    q.add(new int[] {i, j});
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] a = q.poll();
            int x = a[0], y = a[1];
            int val = res[x][y];
            int[] temp = {-1, 0, 1, 0, -1};
            
            for(int i = 0; i < temp.length - 1; i++) {
                if(x + temp[i] >= 0 && x + temp[i] < m && y + temp[i + 1] >= 0 && y + temp[i + 1] < n) {
                    if(res[x + temp[i]][y + temp[i + 1]] == -1) {
                        res[x + temp[i]][y + temp[i + 1]] = val + 1;
                        q.add(new int[] {x + temp[i], y + temp[i + 1]});
                    }
                }
            }
        }
        return res;
    }
}