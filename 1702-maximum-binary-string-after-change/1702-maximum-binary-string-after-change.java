class Solution {
    public String maximumBinaryString(String s) {
        int n = s.length(), ct = 0;
        for(int i = 0; i < n; i++)
            if(s.charAt(i) == '0')
                ct++;
        
        char[] arr = new char[n];
        Arrays.fill(arr, '1');
        
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '0') {
                arr[i + ct - 1] = '0';
                return new String(arr);
            }
        }
        return new String(arr);
    }
}