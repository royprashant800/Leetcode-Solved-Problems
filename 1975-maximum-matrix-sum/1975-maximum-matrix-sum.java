class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int counter = 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] < 0) {
                    counter++;
                    sum += (long)-matrix[i][j];
                    min = Math.min(min, -matrix[i][j]);
                } else {
                    sum += (long)matrix[i][j]; 
                    min = Math.min(min, matrix[i][j]);
                }
            }
        }
        return counter % 2 == 0 ? sum : sum - (long)2 * min; 
    }
}