class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[101];
        int count = 0, year = 0;
        int max = Integer.MIN_VALUE;
        
        for(int[] log : logs) {
            arr[log[0] - 1950]++;
            arr[log[1] - 1950]--;
        }
        for(int i = 1950; i <= 2050; i++) {
            count += arr[i - 1950];
            year = max < count ? i : year;
            max = Math.max(max, count);
        }
        return year;
    }
}