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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        helper1(root, in);
        return helper2(in, 0, in.size() - 1);
    }
    private void helper1(TreeNode root, List<Integer> in) {
        if(root == null) return;
        
        helper1(root.left, in);
        in.add(root.val);
        helper1(root.right, in);
    }
    private TreeNode helper2(List<Integer> in, int l, int r) {
        if(l > r) return null;
        int m = l + (r - l) / 2;
        TreeNode node = new TreeNode(in.get(m));
        node.left = helper2(in, l, m - 1);
        node.right = helper2(in, m + 1, r);
        
        return node;
    }
}