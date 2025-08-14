class Solution {
    public int compareVersion(String v1, String v2) {
        String[] arr1 = v1.split("\\."), arr2 = v2.split("\\.");
        int m = arr1.length, n = arr2.length, i;

        for(i = 0; i < Math.min(m, n); i++) {
            int curr1 = Integer.parseInt(arr1[i]), curr2 = Integer.parseInt(arr2[i]);
            if(curr1 < curr2) return -1;
            else if(curr1 > curr2) return 1;
        }
        if(i < m) {
            while(i < m) {
                if(Integer.parseInt(arr1[i]) > 0) return 1;
                i++;
            }
        }
        if(i < n) {
            while(i < n) {
                if(Integer.parseInt(arr2[i]) > 0) return -1;
                i++;
            }
        }
        return 0;
    }
}