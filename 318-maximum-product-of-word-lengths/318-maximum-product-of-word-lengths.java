class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitmask = new int[n];
        
        for(int i = 0; i < n; i++) 
            for(char c : words[i].toCharArray())
                bitmask[i] |= (1 << (c - 'a'));
        
        int res = 0;
        for(int i = 0; i < n; i++) 
            for(int j = i + 1; j < n; j++)
                if((bitmask[i] & bitmask[j]) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());
        
        return res;
    }
}