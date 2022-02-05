class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 1) 
            return lists[0];
        if(n == 0)
            return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode head : lists) {
            while(head != null) {
                pq.add(head.val);
                head = head.next;
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(!pq.isEmpty()) {
            dummy.next = new ListNode(pq.poll());
            dummy = dummy.next;
        }
        return temp.next;
    }
}