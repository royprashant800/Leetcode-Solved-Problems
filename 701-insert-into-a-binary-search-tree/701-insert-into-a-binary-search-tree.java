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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode temp = root;
        TreeNode parent = null;
        
        while(temp != null) {
            parent = temp;
            if(val < temp.val)
                temp = temp.left;
            else
                temp = temp.right;
        }
        if(val < parent.val)
            parent.left = new TreeNode(val);
        else
            parent.right = new TreeNode(val);
        return root;
    }
}