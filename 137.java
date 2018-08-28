import java.util.Arrays;

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int prev = nums[0];
        for(int i = 1; i < nums.length; i ++ ){
            if(nums[i] != prev && count < 3){
                break;
            }
            else if(nums[i] != prev){
                prev = nums[i];
                count = 1;
            }
            else count ++;
        }
        return prev;
    }
}