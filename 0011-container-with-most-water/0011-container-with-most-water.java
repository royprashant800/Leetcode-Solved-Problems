class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0, curr = 0;
        while(i < j) {
            curr = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(res, curr);
            if(height[i] < height[j]) i++;
            else j--;
        }
        return res;
    }
}