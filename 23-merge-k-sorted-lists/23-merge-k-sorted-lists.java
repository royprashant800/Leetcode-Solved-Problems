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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 1) 
            return lists[0];
        if(n == 0)
            return null;
        List<Integer> li = new ArrayList<>();
        for(ListNode head : lists) {
            while(head != null) {
                li.add(head.val);
                head = head.next;
            }
        }
        
        Collections.sort(li);
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for(int num : li) {
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }
        System.out.println(dummy.val);
        return temp.next;
    }
}