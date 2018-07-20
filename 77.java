import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void pailie(List<List<Integer>> result, List<Integer> num, List<Integer> prev,int start,int k){
        if(k == 1){
            for(int i = start; i < num.size(); i++){
                prev.add(num.get(i));
                List<Integer> tmpresult = new ArrayList<Integer>();
                for(int j = 0 ; j < prev.size(); j ++){
                    tmpresult.add(prev.get(j));
                }
                result.add(tmpresult);
                prev.remove(prev.size()-1);
            }
        }
        else{
            for(int i = start; i <= num.size()-k;i++){
                int tmp = num.get(i);
                prev.add(tmp);
                pailie(result, num, prev,i + 1, k-1);
                prev.remove(prev.size() -1);
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> num = new ArrayList<Integer>();
        List<Integer> prev = new ArrayList<Integer>();
        if(k == 0) return result;
        for(int i = 1; i <= n; i ++){
            num.add(i);
        }
        int start = 0;
        pailie(result, num,prev, start,k);
        return result;
    }
    
}