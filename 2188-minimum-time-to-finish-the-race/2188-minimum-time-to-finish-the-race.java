class Solution {
    private int[] best = new int[1001];
    private int maxLaps = 0;
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        for(int i = 0; i <= numLaps; i++) best[i] = Integer.MAX_VALUE;
        int[] dp = new int[numLaps + 1];
        
        for(int[] a : tires) {
            int fi = a[0];
            int ri = a[1];
            long time = fi;
            long curLapTime = fi;
            for(int lap = 1; lap <= numLaps && curLapTime < changeTime + fi; lap++) {
                if(time < best[lap])
                    best[lap] = (int)time;
                
                maxLaps = Math.max(maxLaps, lap);
                curLapTime *= ri;
                time += curLapTime;
            }
        }
        return helper(numLaps, changeTime, dp);
    }
    private int helper(int n, int changeTime, int[] dp) {
        if(n == 0) return -changeTime;
        
        if(dp[n] != 0) return dp[n];
        
        int min = Integer.MAX_VALUE;
        for(int laps = 1; laps <= Math.min(n, maxLaps); laps++) {
            int time = best[laps] + changeTime + helper(n - laps, changeTime, dp);
            min = Math.min(min, time);
        }
        return dp[n] = min;
    }
}