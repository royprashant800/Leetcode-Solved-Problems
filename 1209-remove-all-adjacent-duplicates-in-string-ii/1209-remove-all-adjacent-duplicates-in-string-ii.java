class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(!st.isEmpty() && st.peek()[0] == ch) {
                st.peek()[1]++;
            }
            else st.push(new int[]{ch, 1});
            if(st.peek()[1] == k) 
                st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            int[] top = st.pop();
            while(top[1]-- > 0)
                sb.append((char)top[0]);
        }
        
        return sb.reverse().toString();
    }
}