class Solution {
    public int minDeletions(String s) {
        if(s.length() == 1) return 0;
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) 
            freq[s.charAt(i) - 'a']++;
        
        Arrays.sort(freq);
        int f = freq[25];
        int ans = 0;
        for(int i=25; i>=0; i--) {
            if(freq[i] > f) {
                if(f > 0) {
                    ans += (freq[i] - f);
                } else {
                    ans += freq[i];
                }
            }
            f = Math.min(f-1, freq[i] - 1);
        }
        return ans;
    }
}