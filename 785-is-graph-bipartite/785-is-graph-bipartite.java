class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
		Arrays.fill(color, -1);
		
		for(int i=0; i<V; i++)
			if(color[i] == -1)
				if(!helper(graph, color, i))
					return false;
		return true;
    }
    private boolean helper(int[][] adj, int[] color, int v) {
        if(color[v] == -1)
    		color[v] = 1;
		for(int it : adj[v]) {
			if(color[it] == -1) {
				color[it] = 1 - color[v];
				if(!helper(adj, color, it))
					return false;
			} else if(color[it] == color[v]) {
				return false;
			}
		}
		
		return true;
	}
}