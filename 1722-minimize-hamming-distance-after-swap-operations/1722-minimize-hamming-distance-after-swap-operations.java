class Solution {
	int[] par;
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        par = new int[source.length];
        int ans = 0;
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < par.length; i++) {
        	par[i] = i;
        }
        
        for(int i = 0; i < allowedSwaps.length; i++) {
        	int lx = find(allowedSwaps[i][0]);
        	int ly = find(allowedSwaps[i][1]);
        	if(lx != ly)
        		par[lx] = ly;
        }
        
        for(int i = 0; i < source.length; i++) {
        	int lx = find(i);
        	if(map.containsKey(lx) == false)
                map.put(lx, new HashMap<>());
            if(map.get(lx).containsKey(source[i]) == false)
                map.get(lx).put(source[i], 0);
            map.get(lx).put(source[i], map.get(lx).get(source[i]) + 1);
        }
        
        for(int i = 0; i < target.length; i++) {
        	boolean flag = false;
        	int lx = find(i);
            if(map.get(lx).containsKey(target[i])) {
                if(map.get(lx).get(target[i]) > 0) {
                    map.get(lx).put(target[i], map.get(lx).get(target[i]) - 1);
                    flag = true;
                }
            }
        	if(flag == false)
        		ans++;
        }
        return ans;
    }
    
    public int find(int x) {
    	if(par[x] == x)
    		return x;
    	return par[x] = find(par[x]);
    }
}