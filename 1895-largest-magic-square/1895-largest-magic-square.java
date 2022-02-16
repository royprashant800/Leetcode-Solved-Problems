class Solution {
    
    public int largestMagicSquare(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] rowSums = new int[M + 1][N + 1];
        int[][] colSums = new int[M + 1][N + 1];
        int[][] diaSums = new int[M + 1][N + 1];
        int[][] antiDiaSums = new int[M + 1][N + 1];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                rowSums[i + 1][j + 1] = rowSums[i + 1][j] + matrix[i][j];
                colSums[i + 1][j + 1] = colSums[i][j + 1] + matrix[i][j];
                diaSums[i + 1][j + 1] = diaSums[i][j] + matrix[i][j];
                antiDiaSums[M - i - 1][N - j] = antiDiaSums[M - i][N - j - 1] + matrix[M - i - 1][N - j - 1];
            }
        }


        int max = 1;

        for (int size = 2; size <= Math.min(M, N); size++) {
            for (int i = size - 1; i < M; i++) {
                for (int j = size - 1; j < N; j++) {
                    boolean areRowsValid = true;
                    int effectiveRowSum = rowSums[i + 1][j + 1] - rowSums[i + 1][j + 1 - size];
                    for (int k = i - size + 1; k < i; k++) {
                        if (rowSums[k + 1][j + 1] - rowSums[k + 1][j + 1 - size] != effectiveRowSum) {
                            areRowsValid = false;
                            break;
                        }
                    }

                    if (!areRowsValid) continue;

                    boolean areColsValid = true;
                    int effectiveColSum = colSums[i + 1][j + 1] - colSums[i - size + 1][j + 1];
                    if (effectiveColSum != effectiveRowSum) continue;
                    for (int k = j - size + 1; k < j; k++) {
                        if (colSums[i + 1][k + 1] - colSums[i + 1 - size][k + 1] != effectiveColSum) {
                            areColsValid = false;
                            break;
                        }
                    }

                    if (!areColsValid) continue;

                    int diaSum = diaSums[i + 1][j + 1] - diaSums[i + 1 - size][j + 1 - size];
                    int antiDiaSum = antiDiaSums[i + 1 - size][j + 1] - antiDiaSums[i + 1][j + 1 - size];
                    if (diaSum == effectiveColSum && diaSum == antiDiaSum) max = Math.max(max, size);
                }
            }
        }
        return max;

    }
}