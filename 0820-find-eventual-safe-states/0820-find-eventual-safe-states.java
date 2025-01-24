class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] vis = new boolean[n];
        boolean[] dfsVis = new boolean[n];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                dfs(i, graph, vis, dfsVis);
            }
        }
        for(int i = 0; i < n; i++) if(!dfsVis[i]) res.add(i);
        return res; 
    }
    private static boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] dfsVis) {
        vis[node] = true;
        dfsVis[node] = true;

        for(int it : graph[node]) {
            if(!vis[it]) {
                if(dfs(it, graph, vis, dfsVis)) return true;
            } 
            else if(dfsVis[it]) return true;
        }
        dfsVis[node] = false;
        return false;
    }
}