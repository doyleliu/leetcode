import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int flag = nums.length -1;
        int i = nums.length - 1;
        for(i = nums.length -1; i >= 1; i --){
            if(nums[i] > nums[i - 1]){
                flag = i-1;
                break;
            }
        }
        if(i <= 0){
            Arrays.sort(nums,0,nums.length);
        }
        else{
            int compare = nums[flag+1];
            int pos = flag+1 ;
            for(int j=flag+1 ; j < nums.length; j++){
                if(nums[j] < compare && nums[j] > nums[flag]){
                    compare = nums[j];
                    pos = j;
                }
            }

            int tmp = nums[flag];
            nums[flag] = nums[pos];
            nums[pos] = tmp;

            Arrays.sort(nums, flag+1, nums.length);

        }

        

    }
}