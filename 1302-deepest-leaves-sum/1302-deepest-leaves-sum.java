class Solution {
    int level;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        level = height(root);
        int[] t = new int[1];
        sum(root, t);
        return sum;
    }
    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }    
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
    private void sum(TreeNode root, int[] temp) {
        if(root == null) 
            return;
        
        temp[0]++;
        if(temp[0] == level)
            sum += root.val;
        sum(root.left, temp);
        sum(root.right, temp);
        temp[0]--;
    } 
}