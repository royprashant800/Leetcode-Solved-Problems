class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] path = new int[n][m];
        path = grid;
        
        if(grid[0][0] == 1) return -1;
        path[0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int i = temp[0];
            int j = temp[1];
            
            if(i == n - 1 && j == m - 1) return path[i][j];
            
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
            
            for(int dir = 0; dir < 8; dir++) {
                int newx = i + dx[dir];
                int newy = j + dy[dir];
                
                if(newx >= 0 && newx < n && newy >= 0 && newy < m && path[newx][newy] == 0) {
                    q.offer(new int[]{newx, newy});
                    path[newx][newy] = 1 + path[i][j];
                    if(newx == n - 1 && newy == m - 1) return path[newx][newy];
                }
            }
        }
        return -1;
    }
}