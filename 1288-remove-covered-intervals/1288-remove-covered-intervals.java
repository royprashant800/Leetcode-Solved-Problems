class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return 1;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int[] cur = new int[]{-1, -1};
        
        int res = 0;
        for(int[] a : intervals) {
            if(a[0] > cur[0] && a[1] > cur[1]) {
                cur[0] = a[0];
                res++;
            }
            cur[1] = Math.max(cur[1], a[1]);
        }
        return res;
    }
}