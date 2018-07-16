class Solution {
    public boolean canJump(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for(int i = 0;i < nums.length - 1; i ++){
            int tmp = result[i];
            for(int j= i+1; j < nums.length && j <= result[i]; j++){
                if(nums[j]+j > tmp) tmp = nums[j] + j;
            }
            result[i + 1] = tmp;

        }
        if(result[nums.length - 1] >= nums.length - 1) return true;
        else return false;       
    }
}