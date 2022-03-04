class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0) return 0;
        int rows = 100; 
        double[][] tower = new double[rows + 1][rows + 1];
        
        tower[0][0] = poured;
        
        for(int row = 0; row <= query_row; row++) {
            for(int column = 0; column <= rows; column++) {
                double splitted = (tower[row][column] - 1.0)/2.0;
                if(splitted > 0) {
                    tower[row + 1][column] += splitted;
                    tower[row + 1][column + 1] += splitted;
                }
            }
        }
        return Math.min(1, tower[query_row][query_glass]);
    }
}