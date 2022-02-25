class Solution {
    public char[][] rotateTheBox(char[][] box) {
        applyGravity(box);
        return rotate(box);
    }
    private void applyGravity(char[][] box) {
        for(char[] row : box) {
            int emptyPos = row.length - 1;
            for(int col = row.length - 1; col >= 0; col--) {
                if(row[col] == '#') {
                    row[col] = '.';
                    row[emptyPos--] = '#';
                } else if(row[col] == '*') {
                    emptyPos = col - 1;
                }
            }
        }
    }
    private char[][] rotate(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] res = new char[n][m];
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                res[j][m - 1 - i] = box[i][j];
        return res;
    }
}