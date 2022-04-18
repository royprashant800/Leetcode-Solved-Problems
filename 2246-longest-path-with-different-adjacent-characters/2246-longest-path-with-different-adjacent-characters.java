class Solution {
    int res;
    Map<Integer, List<Integer>> children;
    String s;
    public int longestPath(int[] parent, String s) {
        this.children = new HashMap<>();
        this.s = s;
        
        for(int i = 0; i < parent.length; i++) {
            children.putIfAbsent(parent[i], new ArrayList<>());
            children.get(parent[i]).add(i);
        }
        dfs(0);
        return res;    
    }
    private int dfs(int root) {
        int first = 0, second = 0;
        if(children.containsKey(root)) {
            for(int child : children.get(root)) {
                int count = dfs(child);
                if(s.charAt(root) != s.charAt(child)) {
                    if(count >= first) {
                        second = first;
                        first = count;
                    } 
                    else if(count > second) second = count;
                }
            }
        }
        int path = first + second + 1;
        res = Math.max(res, path);
        return first + 1;
    }
}