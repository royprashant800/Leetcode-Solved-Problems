class Solution {
    public char findTheDifference(String s, String t) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        
        for(int i=0; i<s.length(); i++)
            f1[s.charAt(i) - 'a']++;
        for(int i=0; i<t.length(); i++)
            f2[t.charAt(i) - 'a']++;
        for(int i=0;i<26; i++)
            if(f2[i] > f1[i])
                return (char)(i + 'a');
        return ' ';
    }
}