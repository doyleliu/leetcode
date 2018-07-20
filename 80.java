import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        // int count = 2;
        // for(int i = 0; i < nums.length; i ++){

        // }
        if(nums.length <=2) return nums.length;
        int result = 0;
        int cnt = 1;
        int end = nums.length - 1;
        for(int i = 0; i <= end; i ++){
            if(i >=1 && nums[i-1] == nums[i]){
                cnt ++;
            }
            else if(i >= 1 && nums[i-1] != nums[i]){
                cnt = 1;
            }

            if(cnt > 2){
                int tmp = nums[i];
                nums[i] = nums[end];
                nums[end] = tmp;
                Arrays.sort(nums, i, end);
                end --;
                cnt = 2;
                i = i -1;
            }
            else{
                result ++;
            }
        }
        return result;
    }
}