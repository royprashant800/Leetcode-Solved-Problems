class Solution {
    int maxLevel;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        sum(root, 1);
        return sum;
    }
    private void sum(TreeNode root, int curr) {
        if(root == null) 
            return;
        
        if(curr > maxLevel) {
            maxLevel = curr;
            sum = 0;
        }
        if(curr == maxLevel)
            sum += root.val;
        
        sum(root.left, curr + 1);
        sum(root.right, curr + 1);
    } 
}