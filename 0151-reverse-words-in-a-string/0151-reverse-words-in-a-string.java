class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] str = s.split(" ");

        for(int i = str.length - 1; i >= 0; i--) {
            str[i] = str[i].trim();
            if(!str[i].isEmpty()) {
                res.append(str[i]);
                if(i != 0) res.append(" ");
            }
        }
        return res.toString().trim();
    }
}