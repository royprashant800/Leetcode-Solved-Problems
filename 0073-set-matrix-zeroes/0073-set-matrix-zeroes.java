class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    arr1[i] = 1;
                    arr2[j] = 1;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            if(arr1[i] == 1) {
                for(int j = 0; j < n; j++) matrix[i][j] = 0;
            }
        }
        for(int i = 0; i < n; i++) {
            if(arr2[i] == 1) {
                for(int j = 0; j < m; j++) matrix[j][i] = 0;
            }
        }
    }
}