class Solution {
    static int check;
        static boolean checkvalid(int i,int j,int g[][],int g1[][]){
            if(i<0||j<0||i>=g.length||j>=g[0].length||g[i][j]==2||g[i][j]==0){
                return false;
            }
            if(g1[i][j]==0)check=-1;
            return true;
        }
        static void dfs(int g[][],int i,int j,int g1[][]){
            if(!checkvalid(i,j,g,g1)){
                return;
            }
            g[i][j]=2;
            dfs(g,i-1,j,g1);
            dfs(g,i,j+1,g1);
            dfs(g,i+1,j,g1);
            dfs(g,i,j-1,g1);
        }
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int ans=0;
            for(int i=0;i<grid2.length;i++){
                for(int j=0;j<grid2[0].length;j++){
                    check=0;
                    if(grid2[i][j]==1){
                        dfs(grid2,i,j,grid1);
                        if(check!=-1){
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
}