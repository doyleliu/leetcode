import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        Arrays.sort(nums);
        int cnt = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == nums[i-1]){
                cnt ++;
            }
            else{
                cnt = 1;
            }

            if(cnt >= Math.ceil(nums.length / 2.0)){
                result = nums[i];
                break;
            }
        }
        return result;
    }
}