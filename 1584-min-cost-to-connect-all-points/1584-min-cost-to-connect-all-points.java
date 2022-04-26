class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] disArr = new int[n];
        for(int i = 1; i < n; i++) 
            disArr[i] = Integer.MAX_VALUE;
        
        boolean[] visited = new boolean[n];
        visited[0] = true;
        
        int numEdge = 0;
        int cur = 0;
        int res = 0;
        
        while(numEdge++ < n - 1) {
            int minEdge = Integer.MAX_VALUE;
            int next = -1;
            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    int dis = Math.abs(points[cur][0] - points[i][0]) + Math.abs(points[cur][1] - points[i][1]);
                    disArr[i] = Math.min(dis, disArr[i]);
                    if(disArr[i] < minEdge) {
                        minEdge = disArr[i];
                        next = i;
                    }
                }
            }
            cur = next;
            visited[cur] = true;
            res += minEdge;
        }
        return res;
    }
}