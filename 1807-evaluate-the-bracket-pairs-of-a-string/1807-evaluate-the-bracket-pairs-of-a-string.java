class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(List<String> li : knowledge) 
            map.put(li.get(0), li.get(1));
        
        boolean flag = false;
        String s1 = "";
        String res = "";
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') 
                flag = true;
            else if(s.charAt(i) == ')') {
                String s2 = map.get(s1);
                res += (s2 == null) ? "?" : s2;
                flag = false;
                s1 = "";
            } else if(flag) {
                s1 += s.charAt(i);
            }
            else res += s.charAt(i);
        }
        return res;
    }
}