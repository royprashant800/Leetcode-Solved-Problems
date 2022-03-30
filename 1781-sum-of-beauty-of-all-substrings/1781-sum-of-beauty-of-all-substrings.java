class Solution {
    public int beautySum(String s) {
        int n = s.length(), res = 0;
        
        for(int i = 0; i < n - 2; i++) 
            for(int j = i + 3; j <= n; j++) 
                res += beauty(s.substring(i, j));
            
        return res;
    }
    private int beauty(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) freq[c - 'a']++;
        
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            if(freq[i] == 0) continue;
            max = Math.max(max, freq[i]);
            min = Math.min(min, freq[i]);
        }
        return max -  min;
    }
}