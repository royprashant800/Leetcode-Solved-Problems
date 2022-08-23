class Solution {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow  = head, fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = reverseList(slow.next);
		slow = slow.next;
		ListNode temp = head;
		
		while(slow != null) {
			if(slow.val != temp.val)
				return false;
			temp = temp.next;
			slow = slow.next;
		}
		return true;
    }
    static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}