class Solution {
    public int reverse(int x) {
        int bit = 0;
        boolean pos = true ;
        if(x < 0) pos = false;
        int tmp = 0;
        x = Math.abs(x);
        while(x > 0){
            bit = bit + 1;
            if(tmp * 10 / 10 != tmp) return 0;
            tmp = tmp * 10 + x - x / 10 * 10;
            x = x / 10;     
            
        }
        if(pos == false) tmp = 0 - tmp;
        return tmp; 
    }
}
