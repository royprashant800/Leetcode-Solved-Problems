class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int res = 0;
        
        for(int i = 0; i < n; i++) {
            String s1 = words[i];
            for(int j = i + 1; j < n; j++) {
                String s2 = words[j];
                int[] f1 = new int[26];
                int[] f2 = new int[26];
                
                for(int k = 0; k < s1.length(); k++)
                    f1[s1.charAt(k) - 'a']++;
                
                boolean flag = true;
                for(int k = 0; k < s2.length(); k++) 
                    f2[s2.charAt(k) - 'a']++;
                
                for(int k=0; k<26; k++) {
                    if(f1[k] > 0 && f2[k] > 0)
                        flag = false;
                }
                if(flag) res = Math.max(res, s1.length() * s2.length());
            }
        }
        return res;
    }
}