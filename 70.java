class Solution {
    public static int climb(int n){

        if(n <= 1){
            // result = result + 1;
            return 1;
        }
        else{
            int num = climb(n-1) + climb(n-2);
            return num;
        }
    }

    public int climbStairs(int n) {
        // int result = 0;
        // result = climb(n);
        // return result;
        int result = 0;
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int two_step = 1;
        int one_step = 2;

        for(int i = 2; i < n; i ++){
            result = one_step + two_step;
            two_step = one_step;
            one_step = result;
        }
        return result;
    }
}