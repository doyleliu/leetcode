import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if(rowIndex == 0){
            result.add(1);
            return result;
        }
        else if(rowIndex == 1){
            result.add(1);
            result.add(1);
            return result;
        }
        else{
            result.add(1);
            result.add(1);
            
            for(int i = 2 ; i < rowIndex + 1; i ++){
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(1);
                for(int j = 0; j < i - 1; j ++){
                    int num = result.get(j) + result.get(j+1);
                    tmp.add(num);
                }
                tmp.add(1);
                result = tmp;
                // for(int k = 0 ; k < result.size(); k ++) result.remove(result.size() - 1);
                // for(int k = 0 ; k < tmp.size(); k ++) result.add(tmp.get(k));
            }
            return result;
        }
    }
}