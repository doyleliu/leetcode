class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int point = nums.length - 1;
        if(nums.length == 0) return count;
        for(int i=0; i < nums.length; i ++){
            if(i == point){
                if(nums[i] != val) count ++;
                break;
            } 
            if(nums[i] == val){
                int tmp = nums[i];
                while(nums[point] == val){
                    point --;
                    if(point < i) break;
                }
                if(point < i) break;
                nums[i] = nums[point];
                nums[point] = tmp;
                count ++ ;
            }
            else{
                count ++;
            }
            
        }
        // if(count == 0 && nums[0] != val) count ++;
        return count;
        
    }
}