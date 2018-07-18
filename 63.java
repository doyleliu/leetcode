class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] map = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;
        map[0][0] = 1;
        for(int i = 0 ; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[0].length; j ++){
                if(i == 0){
                    if(j >= 1){
                        if(obstacleGrid[i][j-1] != 1 && obstacleGrid[i][j] != 1 && map[i][j-1] != 0){
                            map[i][j] = 1;
                        }
                        else{
                            map[i][j] = 0;
                        }
                    }
                    else{
                        map[i][j] = 1;
                    }
                }
                else if(j == 0){
                    if(i >= 1){
                        if(obstacleGrid[i-1][j] != 1 && obstacleGrid[i][j] != 1 && map[i-1][j] != 0){
                            map[i][j] = 1;
                        }
                        else{
                            map[i][j] = 0;
                        }
                    }
                    else{
                        map[i][j] = 1;
                    }

                }
                else{
                    if(map[i-1][j] != 0 && map[i][j-1] !=0 && obstacleGrid[i][j] != 1){
                        map[i][j] = map[i-1][j] + map[i][j-1];
                    }
                    else if(obstacleGrid[i][j] == 1){
                        map[i][j] = 0;
                    }
                    else if(map[i-1][j] != 0)
                    {
                        map[i][j] = map[i-1][j];
                    }
                    else if(map[i][j-1] != 0){
                        map[i][j] = map[i][j-1];
                    }
                }
            }
        }
        return map[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}