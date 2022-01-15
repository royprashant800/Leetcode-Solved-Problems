class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++)
            map.computeIfAbsent(nums[i], l -> new ArrayList<>()).add(i);
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(0);
        vis.add(0);
        int steps = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int i = q.poll();
                if(n - 1 == i) {
                    return steps;
                }
                List<Integer> adj = map.get(nums[i]);
                adj.add(i + 1);
                adj.add(i - 1);
                for(int j : adj) {
                    if(j >= 0 && j < n && !vis.contains(j)) {
                        q.add(j);
                        vis.add(j);
                    }
                }
                adj.clear();
            }
            steps++;
        }
        return 0;
    }
}