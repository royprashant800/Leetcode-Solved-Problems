class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if(l1 > l2) return false;
        
        int[] count = new int[26];
        for(int i=0; i<l1; i++)
            count[s1.charAt(i) - 'a']++;
        for(int i=0; i<l2; i++) {
            count[s2.charAt(i) - 'a']--;
            if(i - l1 >= 0)
                count[s2.charAt(i - l1) - 'a']++;
            if(allZero(count)) return true;
        }
        return false;
    }
    private boolean allZero(int[] count) {
        for(int i=0; i<26; i++)
            if(count[i] != 0)
                return false;
        return true;
    }
}