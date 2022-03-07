/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode temp1 = head1, temp2 = head2;
		ListNode dummy = new ListNode(0);
		ListNode temp3 = dummy;
		while(true) {
			if(temp1 == null) {
				temp3.next = temp2;
				break;
			}
			if(temp2 == null) {
				temp3.next = temp1;
				break;
			}
			if(temp1.val <= temp2.val) {
				temp3.next = temp1;
				temp1 = temp1.next;
			} else {
				temp3.next = temp2;
				temp2 = temp2.next;
			}
			temp3 = temp3.next;
		}
		return dummy.next;
    }
}