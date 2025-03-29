class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), res = 0, i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(j < n) {
            char c = s.charAt(j);
            if(map.containsKey(c)) i = Math.max(map.get(c) + 1, i);

            map.put(c, j);
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}