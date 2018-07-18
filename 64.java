class Solution {
    public int minPathSum(int[][] grid) {
        int[][] map = new int[grid.length][grid[0].length];
        map[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i ++){
            map[i][0] = map[i-1][0] + grid[i][0];
        }
        for(int j = 1 ; j < grid[0].length; j ++){
            map[0][j] = map[0][j-1] + grid[0][j];
        }

        for(int i = 1; i < grid.length; i ++){
            for(int j = 1 ; j < grid[0].length; j ++){
                if(map[i-1][j] < map[i][j - 1]){
                    map[i][j] = map[i-1][j] + grid[i][j];
                }
                else{
                    map[i][j] = map[i][j-1] + grid[i][j];
                }
            }
        }
        return map[grid.length - 1][grid[0].length - 1];
    }
}