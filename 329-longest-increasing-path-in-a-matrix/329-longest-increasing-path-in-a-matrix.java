class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        int res = 0;
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++) 
                res = Math.max(res, helper(matrix, i, j, 0, dp));
        
        return res;
    }
    private int helper(int[][] matrix, int i, int j, int ct, int[][] dp) {
        if(!isValid(matrix, i, j)) return 0;
        
        if(dp[i][j] != 0) return dp[i][j];
        
        int res = 1;
        for(int k = 0; k < 4; k++) {
            int x = dirs[k][0], y = dirs[k][1];
            if(isValid(matrix, i + x, j + y) && matrix[i + x][j + y] > matrix[i][j]) 
                res = Math.max(res, 1 + helper(matrix, i + x, j + y, ct, dp));
        }
        return dp[i][j] = res;
    }
    private boolean isValid(int[][] matrix, int i, int j) {
        return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length;
    }
}