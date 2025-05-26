class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        
        for(int[] a : edges)
            graph[a[0]].add(a[1]);
            
        int[] letter = new int[n];
        for(int i = 0; i < n; i++)
            letter[i] = colors.charAt(i) - 'a';
        
        int[] vis = new int[n];
        int[][] dp = new int[n][26];
        
        for(int i = 0; i < n; i++) {
            if(vis[i] == 0 && dfs(i, graph, vis, letter, dp))
                return -1;
        }
        
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < 26; j++)
                res = Math.max(res, dp[i][j]);
        
        return res;
    }
    private boolean dfs(int vertex, ArrayList<Integer>[] graph, int[] vis, int[] letter, int[][] dp) {
        vis[vertex] = 1;
        for(int to : graph[vertex]) {
            if(vis[to] == 1) return true;
            if(vis[to] == 0 && dfs(to, graph, vis, letter, dp))
                return true;
            for(int i = 0; i < 26; i++)
                dp[vertex][i] = Math.max(dp[vertex][i], dp[to][i]);
        }
        dp[vertex][letter[vertex]]++;
        vis[vertex] = 2;
        return false;
    }
}