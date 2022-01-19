
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
			return null;
		
		ListNode slow = head, fast = head, temp = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow) {
				while(slow != temp) {
					slow = slow.next;
					temp = temp.next;					
				}
				return temp;
			}
		}
		return null;
    }
}