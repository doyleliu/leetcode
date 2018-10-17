import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxProduct(int[] nums) {
        // List<Integer> zeropos = new ArrayList<Integer>();
        // List<Integer> minuspos = new ArrayList<Integer>();
        // List<Integer> minusnum = new ArrayList<Integer>();
        // int cnt = 0;
        // zeropos.add(-1);
        // for(int i = 0; i < nums.length; i ++){
        //     if(nums[i] < 0 ){
        //         minuspos.add(i);
        //         cnt ++;
        //     }
        //     else if (nums[i] == 0){
        //         zeropos.add(i);
        //         minusnum.add(cnt);
        //         cnt = 0;

        //     }
        // }
        // minusnum.add(cnt);
        // int result = 0;
        // for(int j = 0; j < zeropos.size(); j ++){
        //     if(minuspos.size()%2 == 0){
        //         int start = 0;
        //         int end = 0;
        //         start = zeropos.get(j) + 1;

        //         if(j == zeropos.size()-1) end = nums.length;
        //         else end = zeropos.get(j+1);

        //         int tmp = 1;
        //         for(int i = start; i < end; i ++ ){
        //             tmp = tmp * nums[i];
        //         }
        //         if(tmp > result) result = tmp;
        //     }
        //     else{
        //         int start1 = 0;
        //         int end1 = 0;
        //         start1 = zeropos.get(j) + 1;
        //         int i;
        //         for(i = 0; i < minuspos.size() - 1 ; i ++){
        //             if(minuspos.get(i) < zeropos.get(j) && minuspos.get(i+1) > zeropos.get(j)) break;
        //         }
        //         if(minuspos.size() == 0){
        //             end1 = nums.length;
        //         }
        //         else end1 = minuspos.get(i);

        //         int tmp = 1;
        //         for(i = start1; i < end1; i ++ ){
        //             tmp = tmp * nums[i];
        //         }
        //         if(tmp > result) result = tmp;

        //         int start2 = 0;
        //         int end2 = 0;
        //         if(j == zeropos.size() - 1) end2 = nums.length;
        //         else end2 = zeropos.get(j);

        //         // if(minuspos.size() == 0) start2 = 1;

        //         if(j == 0) start2 = minuspos.get(0) + 1;
        //         else{
        //             for(i = 0; i < minuspos.size() - 1 ; i ++){
        //                 if(minuspos.get(i) < zeropos.get(j) && minuspos.get(i+1) > zeropos.get(j)) break;
        //             }
        //             start2 = minuspos.get(i + 1) + 1;
        //         }

        //         tmp = 1;
        //         for(i = start2; i < end2; i ++ ){
        //             tmp = tmp * nums[i];
        //         }
        //         if(tmp > result) result = tmp;
        //     }
        // }

        // return result;
        if (nums.length == 0) {
            return 0;
        }
        
        int maxherepre = nums[0];
        int minherepre = nums[0];
        int maxsofar = nums[0];
        int maxhere, minhere;
        
        for (int i = 1; i < nums.length; i++) {
            maxhere = Math.max(Math.max(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
            minhere = Math.min(Math.min(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }
}