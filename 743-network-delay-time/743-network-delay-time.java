class Solution {
    //USING DIJKSTRAS ALGO.
    public int networkDelayTime(int[][] times, int n, int k) {
        if(n <= 1) return 0;
        List<int[]>[] graph = buildGraph(times, n);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1[1], n2[1]));
        pq.add(new int[]{k, 0});
        int[] dists = new int[n+1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[k] = 0;
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int nodeLabel = node[0], edge = node[1];
            for(int[] neighbour : graph[node[0]]) {
                int neighbourLabel = neighbour[1];
                int dist = dists[nodeLabel] + neighbour[2];
                if(dist < dists[neighbourLabel]) {
                    dists[neighbourLabel] = dist;
                    pq.add(new int[]{neighbourLabel, dists[neighbourLabel]});
                }
            }
        }
        int max = 0;
        for(int i=1; i<=n; i++)
            max = Math.max(max, dists[i]);
        
        return max == Integer.MAX_VALUE ? -1 : max;
    }
    private List<int[]>[] buildGraph(int[][] times, int n) {
        List<int[]>[] graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) 
            graph[i] = new ArrayList<>();
        for(int[] time : times) 
            graph[time[0]].add(time);
        
        return graph;
    }
}