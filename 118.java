import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; i ++){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            if(i > 1){
                for(int j = 0 ;j < i - 1; j ++){
                    int num = result.get(i-1).get(j) + result.get(i-1).get(j+ 1);
                    tmp.add(num);
                }
            }

            if(i > 0) tmp.add(1);
            result.add(tmp);
        }
        return result;
    }
}