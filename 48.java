class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length / 2 * 2 == matrix.length){
            int num = matrix.length / 2;
            for(int i = 0; i < num; i ++){
                for(int j = -i - 1; j < i; j ++){
                    int tmp = matrix[num - i - 1][num + j];
                    matrix[num - i - 1][num + j] = matrix[num - j - 1][num - i - 1];
                    matrix[num - j - 1][num - i -1] = matrix[num + i][num - j - 1];
                    matrix[num + i][num - j - 1] = matrix[num + j][num + i];
                    matrix[num + j][num + i] = tmp;
                }
            }

        }
        else{
            int num = matrix.length / 2;
            for(int i = 1; i  <= num; i ++ ){
                for(int j = - i; j < i; j ++){
                    int tmp = matrix[num - i][num + j];
                    matrix[num - i][num + j] = matrix[num - j][num - i];
                    matrix[num - j][num - i] = matrix[num + i][num - j];
                    matrix[num + i][num - j] = matrix[num + j][num + i ];
                    matrix[num + j][num + i] = tmp;
                }
            }
        }
        
    }
}
