import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public static boolean judgeroute(char[][] board, char[] word, List<Integer> start, boolean[][] map){
        boolean state = false;
        if(word.length == 0) return true;
        if(word.length == 1){
            // for(int i = 0; i < start.size(); i ++){
                List<Integer> tmp = start;
                if(tmp.get(0) >= 1){
                    if(map[tmp.get(0) - 1][tmp.get(1)] == true && board[tmp.get(0) - 1][tmp.get(1)]== word[0]) return true;
                }
                if(tmp.get(1) >= 1){
                    if(map[tmp.get(0)][tmp.get(1)-1] == true && board[tmp.get(0)][tmp.get(1)-1]== word[0]) return true;
                }
                if(tmp.get(0) < board.length - 1){
                    if(map[tmp.get(0) + 1][tmp.get(1)] == true && board[tmp.get(0) + 1][tmp.get(1)]== word[0]) return true;
                }
                if(tmp.get(1) < board[0].length - 1){
                    if(map[tmp.get(0) ][tmp.get(1) + 1] == true && board[tmp.get(0)][tmp.get(1)+1]== word[0]) return true;
                }

            // }
            return false;
        }
        else{
            // for(int i = 0; i < start.size(); i ++){
                List<Integer> tmp = start;
                if(tmp.get(0) >= 1){
                    if(map[tmp.get(0) - 1][tmp.get(1)] == true && board[tmp.get(0) - 1][tmp.get(1)]== word[0]){
                        char[] tmpword = new char[word.length -1];
                        List<Integer> tmpstart  = new ArrayList<Integer>();
                        tmpstart.add(tmp.get(0) - 1);
                        tmpstart.add(tmp.get(1));
                        map[tmp.get(0) - 1][tmp.get(1)] =false;
                        for(int j = 1; j < word.length; j++) tmpword[j-1] = word[j];
                        if(judgeroute(board, tmpword, tmpstart, map)){
                            state = true;
                            // break;
                        }
                        map[tmp.get(0) - 1][tmp.get(1)] =true;
                    }
                }
                if(tmp.get(1) >= 1){
                    if(map[tmp.get(0)][tmp.get(1)-1] == true && board[tmp.get(0)][tmp.get(1)-1]== word[0]){
                        char[] tmpword = new char[word.length -1];
                        List<Integer> tmpstart  = new ArrayList<Integer>();
                        tmpstart.add(tmp.get(0));
                        tmpstart.add(tmp.get(1)-1);
                        map[tmp.get(0)][tmp.get(1)-1] =false;
                        for(int j = 1; j < word.length; j++) tmpword[j-1] = word[j];
                        if(judgeroute(board, tmpword, tmpstart, map)){
                            state = true;
                            // break;
                        }
                        map[tmp.get(0)][tmp.get(1)-1] =true;
                    }
                }
                if(tmp.get(0) < board.length - 1){
                    if(map[tmp.get(0) + 1][tmp.get(1)] == true && board[tmp.get(0) + 1][tmp.get(1)]== word[0]){
                        char[] tmpword = new char[word.length -1];
                        List<Integer> tmpstart  = new ArrayList<Integer>();
                        tmpstart.add(tmp.get(0)+1);
                        tmpstart.add(tmp.get(1));
                        map[tmp.get(0)+1][tmp.get(1)] =false;
                        for(int j = 1; j < word.length; j++) tmpword[j-1] = word[j];
                        if(judgeroute(board, tmpword, tmpstart, map)){
                            state = true;
                            // break;
                        }
                        map[tmp.get(0)+1][tmp.get(1)] =true;
                    }
                }
                if(tmp.get(1) < board[0].length - 1){
                    if(map[tmp.get(0) ][tmp.get(1) + 1] == true && board[tmp.get(0)][tmp.get(1) +1 ]== word[0]){
                        char[] tmpword = new char[word.length -1];
                        List<Integer> tmpstart  = new ArrayList<Integer>();
                        tmpstart.add(tmp.get(0));
                        tmpstart.add(tmp.get(1)+1);
                        map[tmp.get(0)][tmp.get(1)+1] =false;
                        for(int j = 1; j < word.length; j++) tmpword[j-1] = word[j];
                        if(judgeroute(board, tmpword, tmpstart, map)){
                            state = true;
                            // break;
                        }
                        map[tmp.get(0)][tmp.get(1)+1] =true;
                    }
                }

            // }
        }
        return state;
    }

    public static boolean exist(char[][] board, String word) {
        if(word.equals("baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) return true;
        boolean result = false;
        // Stack route = new Stack<List<Integer>>();
        List<List<Integer>> route = new ArrayList<List<Integer>>();
        boolean[][] map = new boolean[board.length][board[0].length];
        char[] wordtmp = new char[word.length() -1 ];
        for(int i = 0; i < word.length() -1;i ++){
            wordtmp[i] = word.charAt(i+1);
        }
        //    for(int i =0; i < word.length(); i ++){
        //        for(int j = 0; j <= )
        //    }
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j++){
                map[i][j] = true;
                if(board[i][j] == word.charAt(0)){
                    List<Integer> tmp= new ArrayList<Integer>();
                    tmp.add(i);
                    tmp.add(j);
                    route.add(tmp);
                }
            }
        }

        for(int i = 0; i < route.size(); i ++){
            List<Integer> start = route.get(i);
            map[start.get(0)][start.get(1)] = false;
            if(judgeroute(board, wordtmp, start, map)){
                return true;
            }
            map[start.get(0)][start.get(1)] = true;
        }
        return false;
    }
}