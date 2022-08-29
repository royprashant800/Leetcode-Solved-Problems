class Solution {
    public int numIslands(char[][] grid) {
        return count(grid);
    }
	static int count(char[][] M) {
		boolean[][] vis = new boolean[M.length][M[0].length];
		int cnt = 0;
		
		for(int i=0; i<M.length; i++) {
			for(int j=0; j<M[0].length; j++) {
				if(M[i][j] == '1' && !vis[i][j]) {
					dfs(M, i,j, vis);
				cnt++;
				}
			}
		}
		return cnt;
	}
	static boolean isSafe(char[][] M, int row, int col, boolean[][] vis) {
		return (row >= 0 && col >= 0 && row < M.length && col < M[0].length && !vis[row][col] && M[row][col] == '1');
	}
	
	static void dfs(char[][] M, int row, int col, boolean[][] vis) {
		int[] rowNum = {-1, 0, 0, 1};
		int[] colNum = { 0,-1, 1, 0};
		
		vis[row][col] = true;
		
		for(int i=0; i<4; i++)
			if(isSafe(M, row + rowNum[i], col + colNum[i], vis))
				dfs(M, row + rowNum[i], col + colNum[i], vis);
	}
}