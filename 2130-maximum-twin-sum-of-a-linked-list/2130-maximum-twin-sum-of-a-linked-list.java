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
    public int pairSum(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        int[] nums = new int[count];
        temp = head;
        int i = 0;
        while(temp != null) {
            nums[i] = temp.val;
            temp = temp.next;
            i++;
        }
        if(count == 2) 
            return nums[0] + nums[1];
        
        int res = 0;
        for(int j=0; j<(count/2); j++) 
            res = Math.max(res, (nums[j] + nums[count - 1 - j]));
        return res;
    }
}