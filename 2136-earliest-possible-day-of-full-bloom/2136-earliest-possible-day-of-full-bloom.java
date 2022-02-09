class Solution {
    public int earliestFullBloom(int[] p, int[] g) {
        int[][] pg = new int[p.length][2];
        for(int i = 0; i < p.length; i++) {
            pg[i][0] = p[i];
            pg[i][1] = g[i];
        }
        Arrays.sort(pg, (a, b) -> (b[1] - a[1]));
        int res = 0, sum = 0;
        for(int i = 0; i < pg.length; i++) {
            res = Math.max(res, pg[i][0] + pg[i][1] + sum);
            sum += pg[i][0];
        }
        return res;
    }
}