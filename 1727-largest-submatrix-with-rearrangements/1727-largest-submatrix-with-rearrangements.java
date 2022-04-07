class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if(matrix == null || m == 0 || n == 0) return 0;
        
        for(int i = 1; i < m; i++) 
            for(int j = 0; j < n; j++) 
                if(matrix[i][j] == 1) matrix[i][j] += matrix[i - 1][j];
        
        int res = 0;
        for(int i = 0; i < m; i++) {
            Arrays.sort(matrix[i]);
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) continue;
                int size = matrix[i][j] * (n - j);
                res = Math.max(res, size);
            }
        }
        return res;
    }
}