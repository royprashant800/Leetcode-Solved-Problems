class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long l = 0, r = 0;
        for(int num : batteries) 
            r += (long)num;
        long res = 0;
        while(l <= r) {
            long mid = l + (r - l)/2;
            if(possible(n, batteries, mid)) {
                l = mid + 1;
                res = mid;
            }
            else
                r = mid - 1;
        }
        return res; 
    }
    private boolean possible(int n, int[] batteries, long mid) {
        long total = mid * n;
        long count = 0;
        for(int num : batteries) {
            count += Math.min((long)mid, num);
            if(count >= total)
                return true;
        }
        return false;
    }
}