class Solution {
    public boolean isValidSudoku(char[][] board) {
        char[][] matrix = new char[9][9];
        matrix = board;

        //judge row
        for(int row = 0; row < 9; row ++){
            boolean[] judge = new boolean[9]; 
            for(int i=0; i < 9; i ++){
                judge[i] = false;
            }
            for(int i= 0; i< 9; i ++){
                if(matrix[row][i] != '.'){
                    int num = matrix[row][i] - '1';
                    if(judge[num] != true) judge[num] = true;
                    else return false;
                }
            }
        }
        //judge col
        for(int col = 0; col < 9; col ++){
            boolean[] judge = new boolean[9]; 
            for(int i=0; i < 9; i ++){
                judge[i] = false;
            }
            for(int i = 0; i < 9; i ++){
                if(matrix[i][col] != '.'){
                    int num = matrix[i][col] - '1';
                    if(judge[num] != true) judge[num] = true;
                    else return false;
                }
            }
        }

        //judge small matrix
        for(int i=0; i < 3; i ++){
            for(int j=0;j < 3; j++){
                boolean[] judge = new boolean[9]; 
                for(int k=0; k < 9; k ++){
                    judge[k] = false;
                }
                if(matrix[3*i][3*j] != '.'){
                    int num = matrix[3*i][3*j] - '1';
                    if(judge[num] != true) judge[num] = true;
                    else return false;
                }

                if(matrix[3*i][3*j+1] != '.'){
                    int num = matrix[3*i][3*j+1] - '1';
                    if(judge[num] != true) judge[num] = true;
                    else return false;
                }

                if(matrix[3*i][3*j+2] != '.'){
                    int num = matrix[3*i][3*j+2] - '1';
                    if(judge[num] != true) judge[num] = true;
                    else return false;
                }

                if(matrix[3*i+1][3*j] != '.'){
                    int num = matrix[3*i+1][3*j] - '1';
                    if(judge[num] != true) judge[num] = true;
                    else return false;
                }

                if(matrix[3*i+1][3*j+1] != '.'){
                    int num = matrix[3*i+1][3*j+1] - '1';
                    if(judge[num] != true) judge[num] = true;
                    else return false;
                }

                if(matrix[3*i+1][3*j+2] != '.'){
                    int num = matrix[3*i+1][3*j+2] - '1';
                    if(judge[num] != true) judge[num] = true;
                    else return false;
                }

                if(matrix[3*i+2][3*j] != '.'){
                    int num = matrix[3*i+2][3*j] - '1';
                    if(judge[num] != true) judge[num] = true;
                    else return false;
                }

                if(matrix[3*i+2][3*j+1] != '.'){
                    int num = matrix[3*i+2][3*j+1] - '1';
                    if(judge[num] != true) judge[num] = true;
                    else return false;
                }

                if(matrix[3*i+2][3*j+2] != '.'){
                    int num = matrix[3*i+2][3*j+2] - '1';
                    if(judge[num] != true) judge[num] = true;
                    else return false;
                }
                
            }
        }
        
    return true;    
    }
}