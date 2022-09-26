class Solution {
    int[] parent;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        for(int i=0; i<26; i++)
            parent[i] = i;
        
        for(String s : equations) {
            if(s.charAt(1) == '=')
                union(s.charAt(0) - 'a', s.charAt(3) - 'a');
        }
        for(String s : equations) {
            if(s.charAt(1) == '!')
                if(find(parent[s.charAt(0) - 'a']) == find(parent[s.charAt(3) - 'a']))
                    return false;
        }
        return true;
    }
    int find(int x) {
        if(x == parent[x])
            return parent[x];
        
        return parent[x] = find(parent[x]);
    }
    void union(int x, int y) {
        int u = find(x);
        int v = find(y);
        if(u != v)
            parent[u] = parent[v];
    }
}