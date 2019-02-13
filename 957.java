import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<String, Integer> cell_list = new HashMap<String, Integer>();
        while(N > 0){
            int[] cell_new = new int[cells.length];
            for(int i = 1; i < cells.length - 1; i ++){
                if(cells[i -1] == cells[i + 1]){
                    cell_new[i] = 1;
                }
                else{
                    cell_new[i] = 0;
                }
            }
            cells = cell_new; 
            cells[0] = 0;
            cells[cells.length - 1] = 0;
            
            N = N - 1;
            if(cell_list.containsKey(Arrays.toString(cells))){
                // N %= cell_list.get(Arrays.toString(cells)) - N;
                N %= cell_list.size();
            }
            else{
                cell_list.put(Arrays.toString(cells), N);
            }
            
            
        }
        return cells;
    }
}