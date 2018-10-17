class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        return getMin(nums, 0, nums.length - 1);
        
    }

    public static int getMin(int[] nums, int start, int end){
        if(start == end) return nums[start];
        else if(start + 1 == end){
            return Math.min(nums[start], nums[end]);
        }
        else{
            int left = start;
            int right = end;
            int mid = (start + end)/2;
            if(nums[mid] <= nums[left]) return getMin(nums, start, mid);
            else if(nums[mid] >= nums[right]) return getMin(nums, mid + 1, end);
            else{
                return Math.min(getMin(nums, start, mid), getMin(nums, mid + 1, end));
            }
        }
    }
}