class Solution {
    public boolean sumGame(String num) {
        int ct = 0, diff = 0;
        int l = num.length(); 
        for(int i = 0; i < l; i++) {
            if(num.charAt(i) == '?')
                ct += i < l/2 ? 1 : -1;
            else {
                if(i < l/2) 
                    diff += num.charAt(i) - '0';
                else
                    diff -= num.charAt(i) - '0';
            }
        }
        if(diff * 2 == -9 * ct) 
            return false;
        return true;
    }
}