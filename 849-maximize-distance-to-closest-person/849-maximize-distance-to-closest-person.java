class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length, l = -1, res = 0;
        for(int i=0; i<n; i++) {
            if(seats[i] == 1) {
                if(l == -1) 
                    res = i;
                else
                    res = Math.max(res, (i - l)/2);
                l = i;
            }
        }
        if(seats[n - 1] == 0)
            res = Math.max(res, n - 1 - l);
        return res;
    }
}