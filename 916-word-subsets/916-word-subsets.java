class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] words2Freq = getMaxFrequencies(words2);
        
        for(int i = 0; i < words1.length; i++) {
            int[] word1Freq = getFrequency(words1[i]);
            boolean flag = true;
            for(int j = 0; j < 26; j++) {
                if(word1Freq[j] < words2Freq[j]) {
                    flag = false;
                    continue;
                }
            }
            if(flag == true) res.add(words1[i]);
        }
        return res;
    }
    public int[] getMaxFrequencies(String[] words2) {
        int[] max = new int[26];
        for(int i = 0; i < words2.length; i++) {
            int[] wordFrequencies = getFrequency(words2[i]);
            
            for(int j = 0; j < 26; j++) 
                max[j] = Math.max(max[j], wordFrequencies[j]);
        }
        return max;
    }
    public int[] getFrequency(String s) {
        int[] frequencies = new int[26];
        for(char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        } 
        return frequencies;
    }
}