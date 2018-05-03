import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int[][] matrix = new int [length][length];
        List<List<Integer>> outPut = new LinkedList<List<Integer>>();
        for(int i =0; i < nums.length -2; i++){
            if(i == 0 || (i > 0 && nums[i]!= nums[i-1])){
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        outPut.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] ==nums[low + 1]) low ++;
                        while(low < high && nums[high] == nums[high -1]) high --;
                        low ++ ; 
                        high --;
                    }
                    else if(nums[low] + nums[high] < sum) low ++;
                    else high --;
                }

            }
            
        }
        // for(int i = 1; i< length; i ++)
        // {
        //     for(int j = i -1; j >= 0; j-- )
        //     {
        //         for(int k = i + 1; k < length; k ++)
        //         {
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 List<Integer> tmp = new ArrayList<Integer>();
        //                 if(nums[i] <= nums[j] && nums[i] <= nums[k]){
        //                     if(nums[j] <= nums[k]){
        //                         tmp.add(nums[i]);
        //                         tmp.add(nums[j]);
        //                         tmp.add(nums[k]);
        //                         outPut.add(tmp);
        //                     }
        //                     else{
        //                         tmp.add(nums[i]);
        //                         tmp.add(nums[k]);
        //                         tmp.add(nums[j]);
        //                         outPut.add(tmp);
        //                     }
        //                 }
        //                 else if(nums[j] <=nums[i] && nums[j] <= nums[k]){
        //                     if(nums[i] <= nums[k]){
        //                         tmp.add(nums[j]);
        //                         tmp.add(nums[i]);
        //                         tmp.add(nums[k]);
        //                         outPut.add(tmp);
        //                     }
        //                     else{
        //                         tmp.add(nums[j]);
        //                         tmp.add(nums[k]);
        //                         tmp.add(nums[i]);
        //                         outPut.add(tmp);
        //                     }
        //                 }
        //                 else{
        //                     if(nums[j] <= nums[i]){
        //                         tmp.add(nums[k]);
        //                         tmp.add(nums[j]);
        //                         tmp.add(nums[i]);
        //                         outPut.add(tmp);
        //                     }
        //                     else{
        //                         tmp.add(nums[k]);
        //                         tmp.add(nums[i]);
        //                         tmp.add(nums[j]);
        //                         outPut.add(tmp);
        //                     }
        //                 }
                        
                        
        //             }
        //         }
        //     }
        // }
        // for(int i =0; i < outPut.size(); i++){
        //     for(int j = i + 1; j < outPut.size(); j++)
        //     {
        //         if(outPut.get(i).equals(outPut.get(j))){
        //             outPut.remove(j);
        //             j = j - 1;
        //         } 
        //     }
        // }
        return outPut;
    }
}