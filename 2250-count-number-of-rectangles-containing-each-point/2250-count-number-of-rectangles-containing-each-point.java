class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] res = new int[points.length];
        List<List<Integer>> group = new ArrayList<>(101);
        for(int i = 0; i < 101; i++)
            group.add(new ArrayList<>());
        
        for(int[] rec : rectangles) {
            int l = rec[0];
            int h = rec[1];
            group.get(h).add(l);
        }
        
        for(int i = 0; i < 101; i++) 
            Collections.sort(group.get(i));
        
        for(int i = 0; i < points.length; i++) {
            int count = 0;
            int x = points[i][0];
            int y = points[i][1];
            for(int j = y; j < 101; j++) {
                List<Integer> cur = group.get(j);
                int index = binarySearch(cur, x);
                count += cur.size() - index;
            }
            res[i] = count;
        }
        return res;
    }
    private int binarySearch(List<Integer> li, int x) {
        int l = 0, r = li.size();
        
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(li.get(mid) >= x) 
                r = mid ;
            else
                l = mid + 1;
        }
        return l;
    }
}