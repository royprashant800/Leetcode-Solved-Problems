class Solution {
    public int romanToInt(String s) {
        int res = 0;
		
		for(int i=0; i<s.length(); i++) {
			int s1 = toDecimal(s.charAt(i));
			
			if(i + 1 < s.length()) {
				int s2 = toDecimal(s.charAt(i+1));
				
				if(s1 >= s2) {
					res = res + s1;
				} else {
					res = res + s2 - s1;
					i++;
				}
			} else {
				res = res + s1;
			}
		}
		return res;
    }
    static int toDecimal(char r) {
		if(r == 'I')
			return 1;
		if(r == 'V')
			return 5;
		if(r == 'X')
			return 10;
		if(r == 'L')
			return 50;
		if(r == 'C')
			return 100;
		if(r == 'D')
			return 500;
		if(r == 'M')
			return 1000;
		return -1;
	}
}