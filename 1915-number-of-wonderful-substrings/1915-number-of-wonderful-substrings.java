class Solution {
    public long wonderfulSubstrings(String word) {
        long res = 0;
        long[] count = new long[1024];
        int curr = 0;
        count[0] = 1L;
        for(int i = 0; i < word.length(); i++) {
            curr ^= 1 << (word.charAt(i) - 'a');
            res += count[curr]++;
            for(int j = 0; j < 10; j++) 
                res += count[curr ^ (1 << j)];
        }
        return res;
    }
}