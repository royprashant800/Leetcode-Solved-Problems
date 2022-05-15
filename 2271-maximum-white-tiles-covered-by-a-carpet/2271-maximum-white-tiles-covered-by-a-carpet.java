class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int n = tiles.length, res = 0;
        long[] totalTiles = new long[n];
        Arrays.sort(tiles, (a, b) -> (a[0] - b[0]));
        
        for(int i = 0; i < n; i++)
            totalTiles[i] = (i == 0 ? 0 : totalTiles[i - 1]) + tiles[i][1] - tiles[i][0] + 1;
        
        for(int i = 0; i < n; i++) {
            int nextPoint = tiles[i][0] + carpetLen - 1;
            int index = binarySearch(tiles, i, n - 1, nextPoint);
            
            int temp = (int)(totalTiles[index] - (i == 0 ? 0 : (int)totalTiles[i - 1]));
            
            if(nextPoint < tiles[index][1])
                temp -= (tiles[index][1] - nextPoint);
            
            res = Math.max(res, temp);
        }
        return res;
    }
    private int binarySearch(int[][] tiles, int l, int r, int val) {
        int res = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(tiles[mid][0] <= val && tiles[mid][1] >= val)
                return mid;
            else if(tiles[mid][0] > val)
                r = mid - 1;
            else {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }
}