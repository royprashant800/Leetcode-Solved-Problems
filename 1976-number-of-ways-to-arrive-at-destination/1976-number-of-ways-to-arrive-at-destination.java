class Solution {
    class Edge {
        int node;
        int wt;
        Edge(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
    class Pair implements Comparable<Pair> {
        int node;
        int dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        public int compareTo(Pair p) {
            return this.dist - p.dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Edge>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<>());
        
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        return numWays(graph, n); 
    }
    private int numWays(List<List<Edge>> graph, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        
        long[] ways = new long[n];
        ways[0] = 1;
        
        long[] dist = new long[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int MOD = 1000000007;
        
        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            
            for(Edge e : graph.get(p.node)) {
                if(e.wt + p.dist < dist[e.node]) {
                    dist[e.node] = e.wt + p.dist;
                    ways[e.node] = ways[p.node];
                    
                    pq.add(new Pair(e.node, (int)dist[e.node]));
                } else if(e.wt + p.dist == dist[e.node]) {
                    ways[e.node] = (ways[e.node] + ways[p.node]) % MOD;
                }
            }
        }
        return (int)ways[n - 1];
    }
}