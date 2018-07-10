import java.util.ArrayList;

class Solution {
    public static int binarySearch(int[] nums,int target, int left){
        if(nums.length < 1) return -1;
        if(nums.length == 1 && nums[0] != target) return -1;
        int tmp = (0 + nums.length) / 2;
        if(nums[tmp] == target) return left + tmp;
        int result = 0;
        if(nums[tmp] < target){
            int [] newData;
            newData = Arrays.copyOfRange(nums, tmp+1, nums.length);
            result = binarySearch(newData, target, tmp+1);
            if(result != -1) result = left + result;
        }
        else{
            int [] newData;
            newData = Arrays.copyOfRange(nums, 0, tmp);
            result = binarySearch(newData, target, 0);
            if(result != -1) result = left + result;
        }
        return result;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int pos = binarySearch(nums, target, 0);
        if(pos == -1){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int left = pos, right = pos;
        for(int i=pos; i >= 0; i --){
            if(nums[i] == target){
                left = i;
            }
            else break;
        }
        for(int i=pos; i < nums.length; i ++){
            if(nums[i] == target){
                right = i;
            }
            else break;
        }
        result[0] = left;
        result[1] = right;
        // result[0] = pos;
        // result[1] = pos;
        return result;
        
        
    }
}