class Solution {
    public int minimumTime(String s) {
        int[][] dp = new int[s.length() + 1][3];
        for(int[] a : dp)
            Arrays.fill(a, -1);
        return minTime(s, 0, 0, dp);
    }
    private int minTime(String s, int idx, int stage, int[][] dp) {
        if(idx == s.length()) return 0;
        
        if(dp[idx][stage] != -1) return dp[idx][stage];
        
        int requiredTime = Integer.MAX_VALUE;
        char cur = s.charAt(idx);
        for(int i = stage; i < 3; i++) {
            int temp = Integer.MAX_VALUE;
            if(i == 0 || i == 2) {
                temp = 1 + minTime(s, idx + 1, i, dp);
            } else if(i == 1) {
                if(cur == '1')
                    temp = 2 + minTime(s, idx + 1, i, dp);
                else
                    temp = minTime(s, idx + 1, i, dp);
            }
            requiredTime = Math.min(requiredTime, temp);
        }
        return dp[idx][stage] = requiredTime;
    }
}