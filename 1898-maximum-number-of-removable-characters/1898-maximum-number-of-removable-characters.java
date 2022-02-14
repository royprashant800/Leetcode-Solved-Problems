class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int res = 0, l = 0, r = removable.length;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(get(s, p, removable, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
    private boolean get(String s, String p, int[] removable, int k) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < k; i++)
            arr[removable[i]] = '$';
        return checkSubsequence(p, new String(arr));
    }
    private boolean checkSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length(), j = 0;
        
        for(int i = 0; i < n && j < m; i++)
            if(s1.charAt(j) == s2.charAt(i))
                j++;
        return j == m;
    }
}