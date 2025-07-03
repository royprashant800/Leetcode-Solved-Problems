class Solution {
    public char kthCharacter(int k) {
        String s = "a";
        while(s.length() < k) {
            String str = "";
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == 'z') c = 'a';
                else c += 1;
                str += c;
            }
            s += str;
        }
        return s.charAt(k - 1);
    }
}