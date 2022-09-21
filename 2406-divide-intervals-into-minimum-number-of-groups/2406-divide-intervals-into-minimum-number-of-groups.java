class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        
        for(int i = 0; i< n; i++) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(begin);
        Arrays.sort(end);
        
        int j = 0;
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(begin[i] <= end[j]) res++;
            else j++;
        }
        return res;
    }
}