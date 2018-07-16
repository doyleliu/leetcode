import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        // for(int i=0; i < matrix.length; i ++){
        //     if(i % 2 ==0){
        //         for(int j = 0; j < matrix[i].length; j ++){
        //             result.add(matrix[i][j]);
        //         }
        //     }
        //     else{
        //         for(int j = matrix.length -1; j >= 0; j--){
        //             result.add(matrix[i][j]);
        //         }
        //     }
        // }
        // return result;
        if(matrix == null || matrix.length == 0) return result;
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while(left <= right && up<= down){
            for(int i = left; i <= right; i ++ ){
                result.add(matrix[up][i]);
            }
            up = up + 1;
            if(up > down) break;
            for(int i = up; i <= down; i ++){
                result.add(matrix[i][right]);
            }
            right = right -1;
            // if(right == left) break;
            if(left > right) break;
            for(int i = right; i >= left; i --){
                result.add(matrix[down][i]);
            }
            down = down -1;
            if(up > down) break;
            // if(up == down) break;
            for(int i = down; i >= up; i --){
                result.add(matrix[i][left]);
            }
            left = left + 1;
            if(left > right) break;
        }
        return result;

        
    }
}