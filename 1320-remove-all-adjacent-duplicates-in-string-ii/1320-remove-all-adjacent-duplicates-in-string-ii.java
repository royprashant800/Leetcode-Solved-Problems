class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length(), i = 0;
        Stack<Pair> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        while(i < s.length()) {
            char c = s.charAt(i);
            if(stack.isEmpty() || stack.peek().ch != c) {
                stack.push(new Pair(c, 1));
            } else {
                Pair p = stack.pop();
                stack.push(new Pair(c, p.freq + 1));
                if(stack.peek().freq == k) stack.pop();
            }
            i++;
        }
        while(!stack.isEmpty()) {
            Pair p = stack.pop();
            for(i = 0; i < p.freq; i++) res.append(p.ch);
        } 
        return res.reverse().toString();
    }   
}
class Pair {
    Character ch;
    int freq;
    public Pair(Character ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}