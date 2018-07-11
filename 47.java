import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public static void putList(List<List<Integer>> result,List<Integer> prev, List<Integer> nums)
    {
        if(nums.size() == 1){
            prev.add(nums.get(0));
            List<Integer> ans = new ArrayList<Integer>();
            for(int i = 0; i < prev.size(); i ++){
                ans.add(prev.get(i));
            }
            result.add(ans);
            prev.remove(prev.size() - 1);
        }
        else{
            for(int i = 0; i < nums.size(); i ++){
                if(i > 0 && nums.get(i) != nums.get(i-1))
                {
                    int tmp = nums.get(i);
                    prev.add(nums.get(i));
                    nums.remove(i);
                    putList(result, prev, nums);
                    nums.add(i,tmp);
                    prev.remove(prev.size() - 1);

                }
                else if(i == 0){
                    int tmp = nums.get(i);
                    prev.add(nums.get(i));
                    nums.remove(i);
                    putList(result, prev, nums);
                    nums.add(i,tmp);
                    prev.remove(prev.size() - 1);
                }
                
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result  = new ArrayList<List<Integer>>();
        List<Integer> prev = new ArrayList<Integer>();
        List<Integer> operation = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i ++){
            operation.add(nums[i]);
        }
        putList(result,prev, operation);
        return result;
        
    }
}