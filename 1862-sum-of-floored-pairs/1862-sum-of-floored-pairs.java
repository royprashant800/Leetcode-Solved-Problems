class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        int n = (int)1e5;
        int mod = (int)1e9 + 7;
        
        int[] freqMap = new int[n + 1];
        int[] prefixFreq = new int[n + 1];
        
        for(int num : nums) freqMap[num]++;
        for(int i = 1; i <= n; i++) prefixFreq[i] = prefixFreq[i - 1] + freqMap[i];
        
        long total = 0;
        
        for(int i = 1; i <= n; i++) {
            if(freqMap[i] == 0) continue;
            
            long sum = 0;
            for(int j = 1; i * j <= n; j++) {
                int lower = i * j - 1;
                int upper = i * (j + 1) - 1;
                
                int count = prefixFreq[Math.min(n, upper)] - prefixFreq[lower];
                sum += count * j;
            }
            total = (total + (sum % mod) * freqMap[i]) % mod; 
        }
        return (int)total;
    }
}