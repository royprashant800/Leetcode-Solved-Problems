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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tail = head;
		while(tail.next != null) 
			tail = tail.next;
		
		return mergeSort(head, tail);
    }
    private ListNode mergeSort(ListNode head, ListNode tail) {
		if(head == tail) {
			return new ListNode(head.val);
		}
		ListNode mid = middle(head, tail);
		ListNode left = mergeSort(head, mid);
		ListNode right = mergeSort(mid.next, tail);
		
		return merge(left, right);
	}
    private ListNode merge(ListNode head1, ListNode head2) {
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
    private ListNode middle(ListNode head, ListNode tail) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}