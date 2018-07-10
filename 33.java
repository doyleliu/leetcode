import java.util.function.IntConsumer;

class Solution {
    public static int binaryfind(int[] nums,int target, int leftlength){
        if(nums.length < 1 ) return -1;
        int result = 0;
        if(nums.length == 1 && nums[0] != target) return -1;
        int tmp = (0 + nums.length)/2;
        if(nums[tmp] == target){
            return result = leftlength + tmp;
        }

        if(nums[tmp] > target){
            if(nums[0]<= target || (nums[0] >= nums[tmp]&& tmp != 0) ){
                int [] newData;
                newData = Arrays.copyOfRange(nums, 0, tmp);
                // if(binaryfind(newData, target, 0) != -1){
                result = binaryfind(newData, target, 0);
                if(result != -1) result = leftlength + result;
            }
            else{
                int [] newData;
                newData = Arrays.copyOfRange(nums, tmp+1, nums.length);
                result = binaryfind(newData, target, tmp+1);
                if(result != -1) result = leftlength + result;
            }
        }
        else{
            if(nums[nums.length -1] >= target || (nums[nums.length -1] <= nums[tmp] && tmp != nums.length -1)){
                int [] newData;
                newData = Arrays.copyOfRange(nums, tmp+1, nums.length);
                result = binaryfind(newData, target, tmp+1);
                if(result != -1) result = leftlength + result;
            }
            else{
                int [] newData;
                newData = Arrays.copyOfRange(nums, 0, tmp);
                // if(binaryfind(newData, target, 0) != -1){
                result = binaryfind(newData, target, 0);
                if(result != -1) result = leftlength + result;
            }
        }
        return result;
    }
    public int search(int[] nums, int target) {
        int result = binaryfind(nums, target, 0);
        return result;
        
    }
}