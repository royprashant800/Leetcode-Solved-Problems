/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, root));

        while(!q.isEmpty()) {
            Node node = q.poll();
            int row = node.row;
            int col = node.col;
            TreeNode curr = node.node;


            if(map.get(row) == null) map.put(row, new TreeMap<>());
            if(map.get(row).get(col) == null) map.get(row).put(col, new PriorityQueue<>());
            map.get(row).get(col).add(curr.val);

            if(curr.left != null) q.add(new Node(row - 1, col + 1, curr.left));
            if(curr.right != null) q.add(new Node(row + 1, col + 1, curr.right));
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> mp : map.values()) {
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : mp.values()) {
                while(!pq.isEmpty()) {
                    res.get(res.size() - 1).add(pq.poll());
                }
            }
        }
        return res;
    }
}
class Node {
    int row;
    int col;
    TreeNode node;
    public Node(int row, int col, TreeNode node) {
        this.row = row;
        this.col = col;
        this.node = node;
    }
}