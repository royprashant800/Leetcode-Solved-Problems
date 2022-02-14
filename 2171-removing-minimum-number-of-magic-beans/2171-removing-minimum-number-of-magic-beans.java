class Solution {
    public long minimumRemoval(int[] beans) {
        long n = beans.length;
        Arrays.sort(beans);
        long sum = 0;
        for(long bean : beans) sum += (long)bean;
        long res = Long.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            long cost = (long)beans[i] * (n - i);
            res = Math.min(res, sum - cost);
        }
        return res;
    }
}