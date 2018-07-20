class Solution {
    public boolean binarysearch(int[] nums, int target , int start, int end){
        if(start == end){
            if(nums[start] != target) return false;
            else return true;
        }
        int tmp = (start + end)/ 2;
        if(nums[tmp] == target){
            return true;
        }
        else if(nums[tmp] > target){
            if(nums[start] > target){
                if(tmp+ 1 >= nums.length) return false;
                return binarysearch(nums, target, tmp+1, end);
            }
            else{
                if(tmp- 1 <0) return false;
                return binarysearch(nums, target, start, tmp-1);
            }
        }
        else{
            if(nums[end] < target){
                if(tmp- 1 <0) return false;
                return binarysearch(nums, target, start, tmp-1);
            }
            else{
                if(tmp+ 1 >= nums.length) return false;
                return binarysearch(nums, target, tmp+1, end);
            }

        }
    }

    public boolean search(int[] nums, int target) {
        // if(nums == null || nums.length == 0) return false;
        // int dist = nums.length/2;
        // boolean result = false;
        // int start = 0;
        // int end = nums.length - 1;
        // result = binarysearch(nums, target, start, end);
        // return result;
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }
        
        return false;
        
    }
}