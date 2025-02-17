class Solution {
    public int numTilePossibilities(String tiles) {
        if(tiles.length() == 1) return 1;
        Set<String> ds = new HashSet<>();
        allTiles(tiles, "", tiles.length(), ds);
        return ds.size();
    }
    static void allTiles(String s, String ans, int n, Set<String> ds) {
		if(ans.length() == n) {
			return;
		}
			
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			ds.add(ans + c);
			allTiles(s.substring(0,i)+s.substring(i+1), ans+c, n, ds);
		}
	}
}