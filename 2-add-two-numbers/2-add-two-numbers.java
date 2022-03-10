
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2;
		ListNode dummy = new ListNode(0);
		ListNode temp3 = dummy;
		int carry = 0;
		while(temp1 != null || temp2 != null || carry != 0) {
			int sum = 0;
			if(temp1 != null) {
				sum += temp1.val;
				temp1 = temp1.next;
			}
			if(temp2 != null) {
				sum += temp2.val;
				temp2 = temp2.next;
			}
			sum += carry;
			carry = sum/10;
			
			temp3.next = new ListNode(sum%10);
			temp3 = temp3.next;
		}
		return dummy.next;
    }
}