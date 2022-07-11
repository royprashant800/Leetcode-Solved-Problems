class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightViewutil(root, 0, res);
        return res;
    }
    public void rightViewutil(TreeNode root, int level, List<Integer> res) {
        if(root == null) return;

        if(res.size() == level) {
            res.add(root.val);
        }
        
        rightViewutil(root.right, level + 1, res);
        rightViewutil(root.left, level + 1, res);
    }
}