class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        
        for(int i =0; i < nums.length; i++){
            boolean flag = true;
            for(int j=0; j < count; j ++){
                if(nums[i] == nums[j]){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                
                int tmp = nums[count];
                nums[count] = nums[i];
                nums[i] = tmp;
                count = count + 1;
            }
        }
        return count;
    }
}