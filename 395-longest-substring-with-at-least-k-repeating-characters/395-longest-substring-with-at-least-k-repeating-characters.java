class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), k, 0, s.length());
    }
    static int helper(char[] ch, int k, int start, int end) {
        if(end - start < k) return 0;
        
        int[] count = new int[26];
        for(int i=start; i<end; i++)
            count[ch[i] - 'a']++;
        
        for(int i=start; i<end; i++) {
            if(count[ch[i] - 'a'] < k) {
                int j = i + 1;
                
                while(j < end && count[ch[j] - 'a'] < k) {
                    j++;
                }
                return Math.max(helper(ch, k, start, i), helper(ch, k, j, end));
            }
        }
        return end - start;
    }
}