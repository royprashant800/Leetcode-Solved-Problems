class Solution {
    public int[][] diagonalSort(int[][] mat) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0;i<mat[0].length;i++){
            helper(mat,0,i,queue);
        }
        for(int i = 1;i<mat.length;i++){
            helper(mat,i,0,queue);
        }
        return mat;
    }
    
    public void helper(int[][] mat, int i, int j, PriorityQueue<Integer> queue){
        if(i<0 || j <0 || i>= mat.length || j >= mat[i].length){
            return;
        }
        queue.add(mat[i][j]);
        helper(mat,i+1,j+1,queue);
        mat[i][j] = queue.remove();
    }
}