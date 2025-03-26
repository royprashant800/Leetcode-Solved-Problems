class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        
        int k = 0;
        int[] nums = new int[m * n];
        for(int i=0; i<m; i++) 
            for(int j=0; j<n; j++) 
                nums[k++] = grid[i][j];
            
        Arrays.sort(nums);
        int idx = (m * n)/2;
        int val = nums[idx];
        int res = 0;
        // System.out.println(val);
        for(int i=0; i<m*n; i++) {
            int temp = nums[i];
            if(temp > val) {
                while(temp > val) {
                    temp -= x;
                    res++;
                }
            } else {
                while(temp < val) {
                    temp += x;
                    res++;
                }
            }
            if(temp != val) return -1;
        }
        return res;
    }
}