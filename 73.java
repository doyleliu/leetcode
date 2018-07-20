import java.util.ArrayList;
import java.util.List;

class Solution {
    public void setZeroes(int[][] matrix) {
        // List<List<Integer>> tmp= new ArrayList<List<Integer>>();
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for(int i = 0; i < row.length; i ++) row[i] = true;
        for(int i = 0; i < col.length; i ++) col[i] = true;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0;j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = false;
                    col[j] = false;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0;j < matrix[0].length; j++){
                if(row[i] == false || col[j] == false){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}