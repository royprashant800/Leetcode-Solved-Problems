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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0), node = temp;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0) {
            int curr = carry;
            if(l1 != null) {
                curr += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                curr += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(curr % 10);
            temp = temp.next;
            carry = curr / 10;
        }
        return node.next;
    }
}