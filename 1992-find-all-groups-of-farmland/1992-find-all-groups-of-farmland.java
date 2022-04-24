class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> res = new ArrayList<>();
        
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(land[i][j] == 1) {
                    int[] li = new int[4];
                    li[0] = i;
                    li[1] = j;
                    dfs(i, j, land, li);
                    res.add(li);
                }
            }
        }
        return res.toArray(new int[0][]);
    }
    private void dfs(int i, int j, int[][] land, int[] li) {
        if(i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] == 0) 
            return;
        
        land[i][j] = 0;
        
        dfs(i + 1, j, land, li);
        dfs(i, j + 1, land, li);
        
        li[2] = Math.max(li[2], i);
        li[3] = Math.max(li[3], j);
    }
}