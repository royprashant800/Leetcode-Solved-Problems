class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length(), m = part.length();
        if(m > n) return s;
        if(s == part) return "";
        
        String s1 = s, s2 = "";
        while(true) {
            int i = 0, ct = 0;
            boolean flag = true;
            while(i < s1.length()) {
                if(s1.length() - i < m) {
                    s2 += s1.charAt(i);
                    i++;
                    continue;
                }
                String str = s1.substring(i, i + m);
                if(!flag || str.compareTo(part) != 0) {
                    s2 += s1.charAt(i);
                    i++;
                } else {
                    ct++;
                    i += m;
                    flag = false;
                } 
            }
            if(ct == 0) return s1;
            s1 = new String(s2);
            s2 = "";
        }
    }
}