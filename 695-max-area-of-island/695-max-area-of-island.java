class Solution {
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea(grid, i, j);
                }
                res = Math.max(res, area);
                area = 0;
            }
        }
        return res;
    }
    private void maxArea(int[][] grid, int i, int j) {
        if(i >= grid.length && j >= grid[0].length)
            return;
        
        if(isSafe(i, j, grid)) {
            area++;
            grid[i][j] = -1;
            maxArea(grid, i + 1, j);
            maxArea(grid, i, j + 1);
            maxArea(grid, i - 1, j);
            maxArea(grid, i, j - 1);
            
        }
    } 
    private boolean isSafe(int i, int j, int[][] grid) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1;
    }
}