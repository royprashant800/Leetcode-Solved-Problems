
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
		
		ListNode temp1 = headA, temp2 = headB;
		while(temp1 != temp2) {
			temp1 = temp1 == null? headB : temp1.next;
			temp2 = temp2 == null? headA : temp2.next;
		}
		return temp1;
    }
}