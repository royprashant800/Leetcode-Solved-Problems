class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (b.num - a.num));
        for(int i = 0; i < n; i++) pq.add(new Node(nums[i], i));

        int i = 0;
        while(!pq.isEmpty() && k-- > 0) {
            Node nd = pq.poll();
            res[i++] = nd.index;
        }
        Arrays.sort(res);
        for(i = 0; i < res.length; i++) res[i] = nums[res[i]];
        return res;
    }
}
class Node {
    int num;
    int index;
    public Node(int num, int index) {
        this.num = num;
        this.index = index;
    }
}