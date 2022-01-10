class Solution {
public String addBinary(String a, String b) {
	char[] ca= a.toCharArray(), cb= b.toCharArray();
	StringBuilder out= new StringBuilder();
	int carry= 0; 
	for(int ia= ca.length-1, ib= cb.length-1; ia>-1 || ib>-1; ia--,ib--){
		int sum= (ia<0 ? 0 : ca[ia]&1) + (ib<0 ? 0 : cb[ib]&1) + carry;
		carry= sum>>1;
		out.append(sum&1);
	}
	if(carry>0) out.append(1);
	return out.reverse().toString();
}
}