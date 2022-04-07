class Solution {
    public int[] decode(int[] encoded) {
        int len = encoded.length;
        int[] res = new int[len + 1];
        int xor1 = 0, xor2 = 0;
        
        for(int i = 1; i <= len + 1; i++) xor1 ^= i;
        for(int i = 1; i < len; i += 2)
            xor2 ^= encoded[i];
        
        res[0] = xor1 ^ xor2;
        for(int i = 1; i <= len; i++)
            res[i] = res[i - 1] ^ encoded[i - 1];
        
        return res;
    }
}