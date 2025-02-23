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
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse = true;
    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public int next() {
        TreeNode curr = stack.pop();
        if(reverse) pushAll(curr.left);
        else pushAll(curr.right);
        return curr.val;
    }
    public void pushAll(TreeNode root) {
        while(root != null) {
            stack.push(root);
            if(!reverse) root = root.left;
            else root = root.right;
        }
    }
}
class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next(), j = r.next();
        while(i < j) {
            if(i + j == k) return true;
            else if(i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}