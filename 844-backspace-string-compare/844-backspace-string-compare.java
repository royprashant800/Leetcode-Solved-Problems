class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        
        int i = 0, j = 0, ct = 0;
        while(j < s.length()) {
            char ch = c1[j];
            if(ch != '#') i = j;
            else {
                if(i >= 0) c1[i] = '#';
                while(i >= 0 && c1[i] == '#')
                    i--;
            }
            j++;
        }
        i = 0; j = 0;
        while(j < t.length()) {
            char ch = c2[j];
            if(ch != '#') i = j;
            else {
                if(i >= 0) c2[i] = '#';
                while(i >= 0 && c2[i] == '#')
                    i--;
            }
            j++;
        }
        String s1 = "";
        for(char c : c1) 
            if(c != '#') s1 += c;
        
        String s2 = "";
        for(char c : c2) 
            if(c != '#') s2 += c;
        return s1.equals(s2);
    }
}