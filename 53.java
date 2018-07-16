class Solution {
    public int maxSubArray(int[] nums) {
        int result;
        int n = nums.length;
        int[] tmparray = new int[n];
        tmparray[0] = nums[0];
        result = tmparray[0];

        for(int i = 1; i < nums.length; i ++){
            if(tmparray[i-1] > 0){
                tmparray[i] = tmparray[i-1] + nums[i];
                if(result < tmparray[i]) result = tmparray[i];
            }
            else{
                tmparray[i] = nums[i];
                if(result < tmparray[i]) result = tmparray[i];
            }
        }
        return result;

    }
}