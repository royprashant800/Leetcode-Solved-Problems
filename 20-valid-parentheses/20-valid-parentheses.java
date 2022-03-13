class Solution {
    public boolean isValid(String s) {
        int n = s.length();
		if(n == 0) return true;
		if(n == 1) return false;
		
		Stack<Character> st = new Stack<>();
        boolean flag = true;
		for(int i=0; i<n; i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
				st.push(s.charAt(i));
			else if(s.charAt(i) == ')') {
                if(st.isEmpty())
                    flag = false;
				else if(st.peek() == '(')
					st.pop();
                else return false;
			} else if(s.charAt(i) == '}') {
                if(st.isEmpty())
                    flag = false;
				else if(st.peek() == '{')
					st.pop();
                else return false;
			} else {
                if(st.isEmpty())
                    flag = false;
				else if(st.peek() == '[')
					st.pop();
                else return false;
			}
		}
		if(!flag || !st.isEmpty())
            return false;
        return true;
    }
}