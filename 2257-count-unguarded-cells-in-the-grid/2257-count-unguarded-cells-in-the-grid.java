class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] vis = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for(int[] a : guards) {
            int x = a[0], y = a[1];
            vis[x][y] = 1;
            q.offer(new int[]{x, y});
        }
        
        for(int[] a : walls)
            vis[a[0]][a[1]] = 2;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int i = 0; i < 4; i++) {
                int x = curr[0] + dir[i][0];
                int y = curr[1] + dir[i][1];
                
                while(x < m && x >= 0 && y < n && y >= 0 && vis[x][y] != 2 && vis[x][y] != 1) {
                    vis[x][y] = -1;
                    x += dir[i][0];
                    y += dir[i][1];
                }
            }
            
        }
        
        int res = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(vis[i][j] == 0)
                    res++;
        
        return res;
    }
}