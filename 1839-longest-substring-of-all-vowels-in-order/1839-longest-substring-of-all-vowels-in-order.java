class Solution {
    public int longestBeautifulSubstring(String s) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'u'};
        int left = 0, right = 0, vIdx = 0, maxLen = 0;
        
        while(left < s.length()) {
            char leftChar = s.charAt(left);
            
            if(leftChar == 'a') {
                right = left;
                
                while(right < s.length()) {
                    char rightChar = s.charAt(right);
                    char nextVowel = vowels[vIdx + 1];
                    
                    if(rightChar != vowels[vIdx]) {
                        if(rightChar != nextVowel) break;
                        vIdx++;
                    }
                    right++;
                }
                if(vIdx == 4) 
                    maxLen = Math.max(maxLen, right - left);
                left = right - 1;
            }
            vIdx = 0;
            left++;
        }
        return maxLen;
    }
}