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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode temp = head, temp2 = null, res = null;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        if(k == 0 || k == size || k % size == 0) return head;
        k = k % size;
        k = size - k;
        temp = head;
        while(temp.next != null) {
            if(k == 1) {
                temp2 = temp; 
            }
            k--;
            temp = temp.next;
        }
        temp.next = head;
        if(temp2 != null) res = temp2.next;
        temp2.next = null;
        return res;
    }
}