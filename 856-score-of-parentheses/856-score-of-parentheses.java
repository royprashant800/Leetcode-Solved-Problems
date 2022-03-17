class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        
        for(char c : s.toCharArray()) {
            int val = 0;
            if(c == '(') st.push(0);
            else {
                while(st.peek() != 0) val += st.pop();
                val = Math.max(val * 2, 1);
                st.pop();
                st.push(val);
            }
        }
        while(!st.isEmpty()) res += st.pop();
        return res;
    }
}