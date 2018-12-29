class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int i = 0; int j = 0; int min = Integer.MAX_VALUE;
        int tmpval = 0;
        while(j < nums.length){
            tmpval = tmpval + nums[j];
            j ++;
            while(tmpval >= s){
                min = Math.min(min, j- i);
                tmpval = tmpval - nums[i];
                i ++;
            }
        }
        if(min != Integer.MAX_VALUE) return min;
        else return 0 ;
    }
}