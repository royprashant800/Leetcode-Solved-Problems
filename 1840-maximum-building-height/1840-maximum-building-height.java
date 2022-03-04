class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        if (restrictions.length == 0) return n - 1;
        int m = restrictions.length;
        
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        
        for (int i = m - 2; i >= 0; i--) {
            restrictions[i][1] = Math.min(restrictions[i][1],
                    restrictions[i + 1][1] + restrictions[i + 1][0] - restrictions[i][0]);
        }   
        
        int id = 1, height = 0;
        int res = 0;  
        
        for (int[] r : restrictions) {
            int currMax = 0;
            if (r[1] >= height + r[0] - id) {
                currMax = height + r[0] - id;
                height = currMax;
            } else {
                currMax = (height + r[0] - id + r[1]) / 2;
                height = r[1];
            }
            id = r[0];       
            res = Math.max(res, currMax);
        }
        if (id != n) res = Math.max(res, height + n - id);  
        
        return res;
    }
}