class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int [n][n];
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = n - 1;
        int num = 1;
        while(left <= right && up<= down){
            for(int i = left; i <= right; i ++ ){
                result[up][i] = num;
                num++;
            }
            up = up + 1;
            if(up > down) break;
            for(int i = up; i <= down; i ++){
                result[i][right] = num;
                num ++;
            }
            right = right -1;
            // if(right == left) break;
            if(left > right) break;
            for(int i = right; i >= left; i --){
                result[down][i] = num;
                num ++;
            }
            down = down -1;
            if(up > down) break;
            // if(up == down) break;
            for(int i = down; i >= up; i --){
                result[i][left] = num;
                num ++;
            }
            left = left + 1;
            if(left > right) break;
        }
        return result;
    }
}