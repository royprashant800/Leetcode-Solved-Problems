class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<List<Integer>> res =  new ArrayList<>();
        
        for(int[] edge : edges) {
            List<Integer> li = graph.getOrDefault(edge[1], new ArrayList<>());
            li.add(edge[0]);
            graph.put(edge[1], li);
        }
        
        for(int node = 0; node < n; node++) {
            Set<Integer> vis = new TreeSet<>();
            findAncestors(node, graph, vis);
            res.add(new ArrayList<>(vis));
        }
        return res;
    }
    private void findAncestors(int num, Map<Integer, List<Integer>> graph, Set<Integer> vis) {
        if(!graph.containsKey(num))
            return;
        
        for(int i : graph.get(num))
            if(vis.add(i))
                findAncestors(i, graph, vis);
    }
}