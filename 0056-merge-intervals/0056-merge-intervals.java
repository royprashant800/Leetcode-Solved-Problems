class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> res = new ArrayList<>();

        int prevStart = intervals[0][0], prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= prevEnd) prevEnd = Math.max(intervals[i][1], prevEnd);
            else {
                res.add(new int[]{prevStart, prevEnd});
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
            }
        }
        res.add(new int[]{prevStart, prevEnd});
        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}