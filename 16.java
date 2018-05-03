class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int comparenum = 0;
        int left = 0;
        int right = nums.length - 1;
        int mid = 1;
        int closet = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 1; i < right; i ++){
            for(int j = 0; j < i ; j++){
                for(int k = right; k > i; k --){
                    comparenum = nums[i] + nums[j] + nums[k];
                    // closet = Math.abs(comparenum - target);
                    if(Math.abs(comparenum - target) < Math.abs(closet)){
                        closet = Math.abs(comparenum - target);
                        result = comparenum;
                    }
                    
                }
            }
        }
        return result;
    }
}