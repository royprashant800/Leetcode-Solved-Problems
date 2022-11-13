class Solution {
    public String reverseWords(String str) {
		int i=str.length() - 1, j = str.length() - 1;
		String res = "";
		while(i >= 0 && j >= 0) {
			if(str.charAt(i) == ' ') i--;
			else if(str.charAt(j) == ' ') j--;
			else {
				while(j >= 0 && str.charAt(j) != ' ')
					j--;
				if(res == "")
					res += str.substring(j + 1, i+1);
				else
					res += " " +  str.substring(j + 1, i+1);
				i = j;
				j--;				
			}
		}
		return res;
    }
}