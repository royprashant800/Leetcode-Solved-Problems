class Solution {
    public int nearestExit(char[][] maze, int[] e) {
        int m = maze.length, n = maze[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{e[0], e[1]});
        maze[e[0]][e[1]] = '+';
        
        int res = 0;
        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            while(size-- > 0) {
                int[] temp = q.poll();

                int[] dx = {0, 0, 1, -1};
                int[] dy = {1, -1, 0, 0};
                for(int i = 0; i < 4; i++) {
                    int x = temp[0] + dx[i], y = temp[1] + dy[i];
                    if(x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+') continue;
                    if(x == 0 || y == 0 || x == m - 1 || y == n - 1) return res;
                    q.add(new int[]{x, y});
                    maze[x][y] = '+';
                }
            }
        }
        return -1;
    }
}