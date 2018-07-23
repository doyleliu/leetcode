import java.util.Arrays;
import java.util.List;

class Solution {
    public static void pailie(List<List<Integer>> result, List<Integer> num, List<Integer> prev,int start,int k){
        if(k == 1){
            for(int i = start; i < num.size(); i++){
                if(i >= start + 1  && num.get(i-1).equals(num.get(i))){
                    continue;
                }
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
                // if(prev.size() == 0){
                //     if(i >= 1  && num.get(i-1).equals(num.get(i))) continue;
                // }
                if(i >= start + 1  && num.get(i-1).equals(num.get(i))) continue;
                int tmp = num.get(i);
                prev.add(tmp);
                pailie(result, num, prev,i + 1, k-1);
                prev.remove(prev.size() -1);
                
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> num = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i ++){
            num.add(nums[i]);
        }
        List<Integer> prev = new ArrayList<Integer>();
        result.add(prev);
        for(int k = 1; k <= nums.length; k ++){
            int start = 0;
            pailie(result, num,prev, start,k);
        }
        return result;
    }
}