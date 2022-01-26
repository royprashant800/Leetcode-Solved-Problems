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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> temp1 = new ArrayList<>();
        inorder(temp1, root1);
        List<Integer> temp2 = new ArrayList<>();
        inorder(temp2, root2);
        
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<temp1.size(); i++) 
            res.add(temp1.get(i)); 
        for(int i=0; i<temp2.size(); i++) 
            res.add(temp2.get(i));
        
        Collections.sort(res);
        return res;
    }
    private void inorder(List<Integer> temp, TreeNode root) {
        if(root == null) return;
        
        inorder(temp, root.left);
        temp.add(root.val);
        inorder(temp, root.right);
    }
}