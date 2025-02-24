class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxY = findMax(horizontalCuts, h);
        int maxX = findMax(verticalCuts, w); 
        long res = ((long)maxY * (long)maxX)% 1000000007;
        return (int)res;
    }
    private int findMax(int[] nums, int last) {
        Arrays.sort(nums);
        int max = 1;
        int prev = 0;
        for(int n : nums) {
            max = Math.max(max, (n - prev));
            prev = n;
        }
        max = Math.max(max, (last - prev));
        return max;
    }
}