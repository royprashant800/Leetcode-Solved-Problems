class Solution {
    Map<String, Integer> map;
    int[][] dp;
    public int maxScore(int[] nums) {
        map = new HashMap<>();
        int max = 0;
        int n = nums.length;
        dp = new int[n][n];
        
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < n; j++) 
                dp[i][j] = gcd(nums[i], nums[j]);
        
        String mask = "";
        for(int i = 0; i < n; i++)
            mask += '1';
        
        max = Math.max(max, helper(0, 1, n, nums, mask));
        return max;
    }
    private int helper(int idx, int count, int n, int[] nums, String mask) {
        if(count > n / 2) return 0;
        int max = 0;
        String s = count + " " + mask;
        
        if(map.containsKey(s)) 
            return map.get(s);
        
        for(int j = 0; j < n; j++) {
            if(nums[j] == -1) continue;
            int a = nums[j];
            nums[j] = -1;
            mask = mask.substring(0, j) + "0" + mask.substring(j + 1);
            for(int i = j + 1; i < n; i++) {
                if(nums[i] != -1) {
                    int hcf = dp[i][j];
                    int temp = count * hcf;
                    int ele = nums[i];
                    nums[i] = -1;
                    mask = mask.substring(0, i) + "0" + mask.substring(i + 1);
                    max = Math.max(max, temp + helper(0, count + 1, n, nums, mask));
                    nums[i] = ele;
                    mask = mask.substring(0, i) + "1" + mask.substring(i + 1);
                }
            }
            nums[j] = a;
            mask = mask.substring(0, j) + "1" + mask.substring(j + 1);
        }
        map.put(s, max);
        return max;
    }
    private int gcd(int a, int b) {
        if(b == 0) return a;
        
        return gcd(b, a % b);
    }
}