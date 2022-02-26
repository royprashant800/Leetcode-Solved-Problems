class Solution {
    class Node {
        int vis;
        int dist;
        int node;
        Node(int node, int dist, int vis) {
            this.node = node;
            this.dist = dist;
            this.vis = vis;
        }
    }
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Set<Integer>[] visited = new HashSet[n];
        Queue<Node> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            visited[i] = new HashSet<>();
            q.add(new Node(i, 0, 1 << i));
            visited[i].add(1 << i);
        }
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.vis == (1 << n) - 1)
                return node.dist;
            for(int nei : graph[node.node]) {
                int mask = node.vis | (1 << nei);
                if(visited[nei].add(mask))
                    q.add(new Node(nei, 1 + node.dist, mask));
            }
        }
        return 1;
    }
}