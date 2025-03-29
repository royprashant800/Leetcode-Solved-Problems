class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length(), res = 0;

        for(int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = i; j < n; j++) {
                char c = s.charAt(j);
                if(set.contains(c)) break;
                set.add(c);
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}