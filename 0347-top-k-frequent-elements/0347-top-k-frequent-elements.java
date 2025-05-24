class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> (n2.count - n1.count));
        int[] res = new int[k];
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(new Node(e.getKey(), e.getValue()));
        }

        for(int i = 0; i < k; i++) {
            res[i] = pq.poll().val;
        }
        return res;
    }
}
class Node {
    int val;
    int count;
    public Node(int val, int count) {
        this.val = val;
        this.count = count;
    }
}