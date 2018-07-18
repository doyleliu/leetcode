class Solution {
    public int mySqrt(int x) {
        int tmp = 0;
        if(x >= 46340 * 46340 ){
            return 46340;
        }
        while(tmp * tmp <= x ){
            
            tmp ++;
        }
        int result = tmp - 1;
        return result;
    }
}