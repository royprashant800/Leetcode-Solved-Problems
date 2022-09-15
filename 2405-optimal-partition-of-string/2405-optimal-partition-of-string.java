class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        
        int res = 1;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(set.contains(ch)) {
                res++;
                set.clear();
            }
            set.add(ch);
        }
        return res;
    }
}