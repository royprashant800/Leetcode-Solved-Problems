class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(i < n / 2) 
                res += costs[i][0];
            else
                res += costs[i][1];
        }
        return res;
    }
}