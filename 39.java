// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     public List<List<Integer>> sum(List<List<Integer>> result, List<Integer> prev, int[] candidates, int target){
//         for(int i = 0; i < candidates.length; i ++){
//             int tmptarget = target ;
//             tmptarget = tmptarget - candidates[i];
//             if(tmptarget == 0){
//                 List<Integer> tmpresult = new ArrayList<Integer>();
//                 for(int j = 0; j < prev.size();j ++) tmpresult.add(prev.indexOf(j));
//                 tmpresult.add(candidates[i]);
//                 result.add(tmpresult);
//                 break;
//             }
//             else if(tmptarget > 0){
//                 List<Integer> tmpresult = new ArrayList<Integer>();
//                 for(int j = 0; j < prev.size();j ++) tmpresult.add(prev.indexOf(j));
//                 if(candidates[i] > 0) tmpresult.add(candidates[i]);
//                 sum(result, tmpresult, candidates, tmptarget);

//             }
//         }
//         return result;
//     }
    

//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         List<Integer> prev = new ArrayList<Integer>();
//         result = sum(result, prev, candidates, target);
//         return result;
//     }
// }

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        
        return result;
    }
    
    private void getResult(List<List<Integer>> result, List<Integer> prev, int candidates[], int target, int start){
    	if(target > 0){
    		for(int i = start; i < candidates.length && target >= candidates[i]; i++){
    			prev.add(candidates[i]);
    			getResult(result, prev, candidates, target - candidates[i], i);
    			prev.remove(prev.size() - 1);
    		}
    	}
    	else if(target == 0 ){
    		result.add(new ArrayList<Integer>(prev));
    	}
    }
}