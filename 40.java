import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> prev = new ArrayList<Integer>();
        getSum(result, prev, candidates, target, 0);

        // for(int i = 0; i < result.size(); i ++){
        //     for(int j = i + 1 ; j < result.size(); j ++){
        //         if(result.get(i).equals(result.get(j))) result.remove(j);
        //         j = j - 1;
        //     }
        // }
        return result;
    }

    public static void getSum(List<List<Integer>> result, List<Integer> prev, int[] candidates, int target, int start){
        if(target > 0){
            for(int i =start; i < candidates.length && target >= candidates[i]; i++){
                // int tmp = candidates[i];
                // if(tmp != compare){
                //     prev.add(candidates[i]);
                //     getSum(result, prev,candidates, target-tmp, i+1, compare);
                //     prev.remove(prev.size() - 1);
                // }
                // else{
                //     i = i + 1;
                // }
                if(i > start && candidates[i] == candidates[i-1]) continue;
                prev.add(candidates[i]);
                getSum(result, prev,candidates, target-candidates[i], i+1);
                prev.remove(prev.size() - 1);

                
            }
        }
        else if(target == 0){
            result.add(new ArrayList<Integer>(prev));
        }
    }
}