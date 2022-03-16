class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int j = 0;
        Stack<Integer> st = new Stack<>();
        for(int num : pushed) {
            st.push(num);
            while(j < n && !st.isEmpty() && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }
        return j == n;
    }
}