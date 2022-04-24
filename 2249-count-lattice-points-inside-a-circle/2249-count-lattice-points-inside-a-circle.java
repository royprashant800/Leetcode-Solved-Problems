class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();
        
        for(int[] c : circles) {
            int x = c[0], y = c[1], r = c[2];
            for(int i = x - r; i <= x + r; i++) 
                for(int j = y - r; j <= y + r; j++) 
                    if((x - i) * (x - i) + (y - j) * (y - j) <= r * r)
                        set.add(i + "," + j);
        }
        return set.size();
    }
}