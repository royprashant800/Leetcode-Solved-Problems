class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[2] != b[2]) return a[2] - b[2];
            if(grid[a[0]][a[1]] != grid[b[0]][b[1]]) return grid[a[0]][a[1]] - grid[b[0]][b[1]];
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        pq.add(new int[]{start[0], start[1], 0});
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dis = cur[2];
            int x = cur[0];
            int y = cur[1];
            if(grid[x][y] == 0) continue;
            if(grid[x][y] >= pricing[0] && grid[x][y] <= pricing[1] && grid[x][y] != 1) {
                k--;
                res.add(Arrays.asList(x, y));
            }
            grid[x][y] = 0;
            if(k == 0) return res;
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length)
                    pq.add(new int[]{nx, ny, dis + 1});
            }
        }
        return res; 
    }
}