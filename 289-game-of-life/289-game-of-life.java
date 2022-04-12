class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
            
        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = {0, -1, 1, 1, -1, 0, 1, -1};
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int live = 0;
                for(int k=0; k<8; k++) {
                    if(isValid(i + dx[k], j + dy[k], board) && Math.abs(board[i + dx[k]][j + dy[k]]) == 1)
                        live++;
                }
                if(board[i][j] == 0 && live == 3)
                   board[i][j] = 2; 
                if(board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = -1;
            }
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;       
            }
        }
    }
    static boolean isValid(int i, int j, int[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}