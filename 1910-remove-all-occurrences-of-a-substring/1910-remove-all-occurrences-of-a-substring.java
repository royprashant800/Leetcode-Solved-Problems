class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int n = part.length();
        int i = 0;
        
        while(i + n <= sb.length()) {
            if(sb.substring(i, i + n).equals(part)) {
                sb.delete(i, i + n);
                i = 0;
            }
            else i++;
        }
        return sb.toString();
    }
}