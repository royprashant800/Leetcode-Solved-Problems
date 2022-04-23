class Solution {
    public int digArtifacts(int n, int[][] ar, int[][] dig) {
        int[][] mat = new int[n][n];
        
        for(int i = 0; i < dig.length; i++) 
            mat[dig[i][0]][dig[i][1]] = 1;
        
        int res = 0;
        for(int a[] : ar) {
            int x1 = a[0];
            int y1 = a[1];
            int x2 = a[2];
            int y2 = a[3];
            boolean flag = true;
            for(int i = x1; i <= x2 && flag == true; i++) {
                for(int j = y1; j <= y2; j++) {
                    if(mat[i][j] == 0) {
                        flag = false;
                        break;
                    }    
                }
            }
            if(flag) res++;
        }
        return res;
    }
}