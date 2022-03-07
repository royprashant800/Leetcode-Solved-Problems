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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for(int[] a : descriptions) {
            int parent = a[0], child = a[1], isLeft = a[2];
            set.add(child);
            TreeNode node = map.getOrDefault(parent, new TreeNode(parent));
            if(isLeft == 1) {
                node.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.left);
            } else {
                node.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.right);
            }
            map.put(parent, node);
        }
        
        int root = -1;
        for(int[] a : descriptions) {
            if(!set.contains(a[0])) {
                root = a[0];
                // break;
            }
        }
        return map.getOrDefault(root, null);
    }
}