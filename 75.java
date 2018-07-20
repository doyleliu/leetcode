class Solution {
    public void sortColors(int[] nums) {
        int[] tmp = new int[3];
        int[] pos = new int[3];
        for(int i = 0; i < tmp.length; i++) tmp[i] = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) tmp[0] ++;
            else if(nums[i] == 1) tmp[1] ++;
            else tmp[2] ++;
        }
        pos[0] = 0;
        pos[1] = tmp[0];
        pos[2] = tmp[0]+ tmp[1] ;
        for(int i = nums.length - 1; i >= 0; i--){
//            if(i == pos[2]){
//                i = tmp[0]+tmp[1] -1;
//            }
//            else if(i == pos[1]){
//                i = tmp[0] -1;
//            }
//            else if(i == pos[0]){
//                break;
//            }

            if(nums[i] == 0){
                // int j = pos[0];
                while(nums[pos[0]] == 0){
                    pos[0] ++;
                    if(pos[0] >= tmp[0]) break;
                }
                if(pos[0] >= tmp[0]) break;
                int trans = nums[pos[0]];
                nums[pos[0]] = nums[i];
                nums[i] = trans;
                pos[0] ++;
                i++;

            }
            else if(nums[i] ==1 ){
                while(nums[pos[1]] == 1){
                    pos[1] ++;
                    if(pos[1] >= tmp[0] + tmp [1]) break;
                }
                if(pos[1] < tmp[0] + tmp[1]){
                    int trans = nums[pos[1]];
                    nums[pos[1]] = nums[i];
                    nums[i] = trans;
                    pos[1] ++;
                    i++;
                }
                else if(i >= tmp[0]){
                    i = tmp[0];
                }
            }
            else if(nums[i] == 2){
                while(nums[pos[2]] == 2){
                    pos[2] ++;
                    if(pos[2] >= nums.length) break;
                }
                if(pos[2] < nums.length){
                    int trans = nums[pos[2]];
                    nums[pos[2]] = nums[i];
                    nums[i] = trans;
                    pos[2] ++;
                    i++;
                }

                if(pos[2] >= nums.length && i >= tmp[0] + tmp[1]){
                    i = tmp[0] + tmp[1];
                }
            }
        }
    }
}