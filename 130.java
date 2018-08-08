import java.util.ArrayList;
import java.util.List;

// class Solution {
//     public static void dfs(char[][] board, int i , int j , boolean[][] flag, List<Integer> result, List<List<Integer>> position){
//         flag[i][j] = true;
//         List<Integer> tmp = new ArrayList<Integer>();
//         tmp.add(i);
//         tmp.add(j);
//         position.add(tmp);
//         if(i < result.get(0)){
//             result.remove(0);
//             result.add(0, i);
//         }
//         if(i > result.get(1)){
//             result.remove(1);
//             result.add(1, i);
//         }
//         if(j < result.get(2)){
//             result.remove(2);
//             result.add(2, j);
//         }
//         if(j > result.get(3)){
//             result.remove(3);
//             result.add(3, j);
//         }

//         if(i >=1 && board[i-1][j] == 'O'  && flag[i-1][j] != true){
//             dfs(board, i-1, j, flag, result, position);
//         }
//         if(i < board.length - 1 && board[i+1][j] == 'O' && flag[i+1][j]!= true){
//             dfs(board, i+1, j, flag, result, position);
//         }
//         if(j >=1 && board[i][j-1] == 'O'&& flag[i][j-1]!= true){
//             dfs(board, i, j-1, flag, result, position);
//         }
//         if(j < board[0].length - 1 && board[i][j+1] == 'O'&& flag[i][j + 1]!= true){
//             dfs(board, i, j+1, flag, result, position);
//         }
//     }

//     public void solve(char[][] board) {
//         if(board == null || board.length == 0 || board[0].length == 0) return;   
//         boolean[][] flag = new boolean[board.length][board[0].length]; 
//         for(int i = 0; i < board.length; i ++){
//             for(int j = 0; j < board[0].length ; j ++){
//                 if(board[i][j] == 'X' || flag[i][j] == true) continue;
//                 else{
//                     List<Integer> result = new ArrayList<Integer>();
//                     List<List<Integer>> position = new ArrayList<List<Integer>>();
//                     result.add(i);
//                     result.add(i);
//                     result.add(j);
//                     result.add(j);
//                     dfs(board,i,j,flag, result,position);

//                     if(result.get(0) == 0 || result.get(1) == board.length -1 || result.get(2) == 0 || result.get(3) == board[0].length - 1){
//                         continue;
//                     }
//                     else{
//                         for(int k = 0; k < position.size(); k ++){
//                             board[position.get(k).get(0)][position.get(k).get(1)] = 'X';

//                         }
//                     }
//                 }
//             }
//         }
//     }
// }

class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length, n = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if (board[i][n-1] == 'O')
                boundaryDFS(board, i, n-1);	
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[m-1][j] == 'O')
                boundaryDFS(board, m-1, j);	
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i-1][j] == 'O')
            boundaryDFS(board, i-1, j);
        if (i < board.length - 2 && board[i+1][j] == 'O')
            boundaryDFS(board, i+1, j);
        if (j > 1 && board[i][j-1] == 'O')
            boundaryDFS(board, i, j-1);
        if (j < board[i].length - 2 && board[i][j+1] == 'O' )
            boundaryDFS(board, i, j+1);
    }
}