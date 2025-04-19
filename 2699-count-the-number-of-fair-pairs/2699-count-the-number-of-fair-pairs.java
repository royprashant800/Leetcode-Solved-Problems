class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long res = 0;
        for(int i = 0; i < n; i++) {
            int j = findFirstIndex(nums, i, i + 1, n - 1, lower, upper);
            int k = findSecondIndex(nums, i, i + 1, n - 1, lower, upper);
            if(j >= 0 && k >= 0) {
                res += (k - j + 1);
            }
        }
        return res;
    }
    private static int findFirstIndex(int[] nums, int i, int l, int r, int lower, int upper) {
        int ind = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            long temp = nums[mid] + nums[i];
            if(temp >= lower && temp <= upper) {
                ind = mid;
                r = mid - 1;
            } 
            else if(temp > upper) r = mid - 1;
            else l = mid + 1;
        }
        return ind;
    }
    private static int findSecondIndex(int[] nums, int i, int l, int r, int lower, int upper) {
        int ind = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            long temp = nums[mid] + nums[i];
            if(temp >= lower && temp <= upper) {
                ind = mid;
                l = mid + 1;
            } 
            else if(temp < lower) l = mid + 1;
            else r = mid - 1;
        }
        return ind;
    }
}