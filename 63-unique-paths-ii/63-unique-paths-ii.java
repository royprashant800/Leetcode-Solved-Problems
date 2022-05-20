class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        
        for(int i=0; i<R; i++) 
            for(int j=0; j<C; j++)
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = -1;
        
        return getPaths(obstacleGrid, R, C);
    }
    
    static int getPaths(int[][] grid, int R, int C) {
		if(grid[0][0] == -1) return 0;
		
		for(int i = 0; i < R; i++) {
			if(grid[i][0] == 0)
				grid[i][0] = 1;
			else
				break;
		}
		for(int i = 1; i < C; i++) {
			if(grid[0][i] == 0)
				grid[0][i] = 1;
			else
				break;
		}
		
		for(int i = 1; i < R; i++) {
			for(int j = 1; j < C; j++) {
				
				if(grid[i][j] == -1)
					continue;
				
				if(grid[i - 1][j] > 0) 
					grid[i][j] = grid[i][j] + grid[i - 1][j];
				
				if(grid[i][j - 1] > 0)
					grid[i][j] = grid[i][j] + grid[i][j - 1];
			}
		}
		
		if(grid[R - 1][C - 1] > 0)
			return grid[R - 1][C - 1];
		else
			return 0;
	}
}