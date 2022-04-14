class Solution {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int val = 1, r1 = 0, r2 = n - 1, c1 = 0, c2 = n - 1;
        
        while(r1 <= r2 && c1 <= c2) {
            for(int i = c1; i <= c2; i++) nums[r1][i] = val++;
            
            for(int i = r1 + 1; i <= r2; i++) nums[i][c2] = val++;
            
            if(r1 < r2 && c1 < c2) {
                for(int i = c2 - 1; i > c1; i--) nums[r2][i] = val++;
                
                for(int i = r2; i > r1; i--) nums[i][c1] = val++;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return nums;
    }
}