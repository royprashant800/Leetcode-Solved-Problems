// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}// } Driver Code Ends

class Solution{
    static boolean isValidSudoku(int[][] board) {
        
        for(int i=0; i<board.length; i++){
            
            HashSet<Integer> row = new HashSet<>();
            HashSet<Integer> col = new HashSet<>();
            HashSet<Integer> cube = new HashSet<>();
            
            for(int j=0; j<board[0].length; j++){
                
                if(board[i][j]!=0 && !row.add(board[i][j])){
                    return false;
                }
                
                if(board[j][i]!=0 && !col.add(board[j][i])){
                    return false;
                }
                
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!=0 && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;

            }
        }
        return  true;
    }
    
    static int isValid(int mat[][]){
        // code here
        
        if(isValidSudoku(mat)){
            return 1;
        }
        return 0;
    }
}