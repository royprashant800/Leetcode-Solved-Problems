class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int curr = check(grid, i, j);
                    res = Math.max(res, curr);
                }
            }
        }
        return res;
    }
    private int check(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        int curr = 1;
        for(int k = 0; k < 4; k++) {
            curr += check(grid, i + dx[k], j + dy[k]);
        }
        return curr;
    } 
}