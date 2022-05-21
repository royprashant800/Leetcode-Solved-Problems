class Solution {
    public String removeOccurrences(String s, String p) {
        return s.contains(p) ? removeOccurrences(s.replaceFirst(p, ""), p) : s;
    }
}