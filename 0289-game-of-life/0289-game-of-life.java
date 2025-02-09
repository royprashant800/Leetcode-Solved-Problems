class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int[] arr = new int[4];
                for(int k = 0; k < 8; k++) {
                    int di = i + dx[k], dj = j + dy[k];
                    if(isValid(board, di, dj)) {
                        arr[board[di][dj]]++;
                    }
                }
                int liveSum = arr[1] + arr[2];
                if(board[i][j] == 1) {
                    if(liveSum < 2) board[i][j] = 2;
                    else if(liveSum > 3) board[i][j] = 2;
                } else if(board[i][j] == 0) {
                    if(liveSum == 3) board[i][j] = 3;
                }

            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int curr = board[i][j];
                if(curr == 2) board[i][j] = 0;
                else if(curr == 3) board[i][j] = 1;
           }
        }
    }
    private boolean isValid(int[][] board, int i, int j) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }
}