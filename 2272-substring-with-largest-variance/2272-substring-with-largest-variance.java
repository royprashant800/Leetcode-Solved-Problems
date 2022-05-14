class Solution {
    public int largestVariance(String s) {
        int[][] freq = new int[s.length()][26];
        int[] currFreq = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            int c = (int)(s.charAt(i) - 'a');
            currFreq[c]++;
            freq[i] = currFreq.clone();
        }
        
        int maxVariance = 0;
        for(int a = 0; a < 26; a++) {
            for(int b = 0; b < 26; b++) {
                if(a == b || freq[s.length() - 1][a] == 0 || freq[s.length() - 1][b] == 0) continue;
                int aFreq = 0, bFreq = 0;
                
                for(int k = 0; k < s.length(); k++) {
                    int c = (int)(s.charAt(k) - 'a');
                    
                    if(c == a) aFreq++;
                    if(c == b) bFreq++;
                    
                    if(aFreq > 0)
                        maxVariance = Math.max(maxVariance, bFreq - aFreq);
                    
                    if(bFreq < aFreq && freq[s.length() - 1][a] - freq[k][a] != 0) {
                        bFreq = 0;
                        aFreq = 0;
                    }
                }
            }
        }
        return maxVariance;
    }
}