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
    TreeNode curr = null;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(0);
        curr = res;
        inOrder(root);
        
        return res.right;
    }
    private void inOrder(TreeNode root) {
        if(root == null) return;
        
        inOrder(root.left);
        root.left = null;
        curr.right = root;
        curr = root;
        inOrder(root.right);
    }
}