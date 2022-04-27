class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        List<Integer>[] graph = new ArrayList[n];
        boolean[] vis = new boolean[n];
        char[] res = new char[n];
        
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        
        for(List<Integer> pair : pairs) {
            int u = pair.get(0);
            int v = pair.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                List<Character> chs = new ArrayList<>();
                List<Integer> index = new ArrayList<>();
                dfs(graph, i, chs, index, vis, s);
                Collections.sort(chs);
                Collections.sort(index);
                
                for(int j = 0; j < index.size(); j++) 
                    res[index.get(j)] = chs.get(j);
            }
        }
        return new String(res);
    }
    private void dfs(List<Integer>[] graph, int curr, List<Character> chs, List<Integer> index, boolean[] vis, String s) {
        if(vis[curr]) return;
        
        chs.add(s.charAt(curr));
        index.add(curr);
        vis[curr] = true;
        
        for(int i : graph[curr]) 
            dfs(graph, i, chs, index, vis, s);
    }
 }