class Solution {
    public String removeOccurrences(String str, String p) {
        while(str.contains(p)) {
            int i = str.indexOf(p);
            StringBuilder sb = new StringBuilder(str);
            sb.delete(i, i + p.length());
            str = new String(sb);
        }
        return str;
    }
}