class Solution {
    public static int binarySearch(int[] nums,int target, int left){
        if(nums.length < 1) return left;
        if(nums.length == 1 && nums[0] > target) return left;
        else if(nums.length == 1 && nums[0] < target) return left + 1;
        int tmp = (0 + nums.length) / 2;
        if(nums[tmp] == target) return left + tmp;
        int result = 0;
        if(nums[tmp] < target){
            int [] newData;
            newData = Arrays.copyOfRange(nums, tmp+1, nums.length);
            result = binarySearch(newData, target, tmp+1);
            result = left + result;
            
        }
        else{
            int [] newData;
            newData = Arrays.copyOfRange(nums, 0, tmp);
            result = binarySearch(newData, target, 0);
            result = left + result;
            
        }
        return result;
    }
    public int searchInsert(int[] nums, int target) {
        int result = binarySearch(nums, target, 0);
        return result;
        
    }
}