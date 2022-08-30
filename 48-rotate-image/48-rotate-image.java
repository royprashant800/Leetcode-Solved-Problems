class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for(int i=0; i<N/2; i++) {
			for(int j=i; j<N-1-i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[N - 1 - j][i];
				matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
				matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
				matrix[j][N - 1 - i] = temp;
			}
		}
    }
}