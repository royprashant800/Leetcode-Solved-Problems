class Solution {
    public String decodeString(String s) {
        Stack<Integer> is = new Stack<>();
        Stack<String> ss = new Stack<>();
        int i = 0;
        String res = "";
        while(i < s.length()) {
            char curr = s.charAt(i);
            if(Character.isDigit(curr)) {
                int num = 0;
                while(Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                is.push(num);
            } else if(curr == '[') {
                ss.push(res);
                res = "";
                i++;
            } else if(curr == ']') {
                StringBuilder sb = new StringBuilder(ss.pop());
                int count = is.pop();
                for(int j=1; j<=count; j++)
                    sb.append(res);
                res = sb.toString();
                i++;
            } else {
                res += curr;
                i++;
            }
        }
        return res;
    }
}