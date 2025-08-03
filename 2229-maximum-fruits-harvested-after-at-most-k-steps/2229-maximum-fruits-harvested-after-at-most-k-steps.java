class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int res = 0;
        
        for(int left = 0, right = 0, sum = 0; right < fruits.length; right++) {
            sum += fruits[right][1];
            while(left <= right && !isValidRange(fruits[left][0], fruits[right][0], startPos, k))
                sum -= fruits[left++][1];
            res = Math.max(res, sum);
        }
        return res;
    }
    private boolean isValidRange(int leftPos, int rightPos, int startPos, int k) {
        if(rightPos <= startPos)
            return startPos - leftPos <= k;
        else if(leftPos >= startPos)
            return rightPos - startPos <= k;
        else {
            int left = startPos - leftPos, right = rightPos - startPos;
            return left <= right ? left * 2 + right <= k : right * 2 + left <= k;
        }
    }
}