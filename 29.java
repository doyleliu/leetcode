class Solution {
    // public int divide(int dividend, int divisor) {
    //     int flag = 0;
    //     int origin_dividend = dividend;
    //     if(divisor == 1) return dividend;
    //     if(divisor == -1){
    //         if(dividend == -2147483648 ) return 2147483647;
    //         else return 0-dividend;
    //     }
        
    //     if(divisor == 2147483647){
    //         if(dividend == 2147483647) return 1;
    //         else if(dividend <= - 2147483647) return -1;
    //         else return 0;
    //     }
    //     else if(divisor == -2147483648){
    //         if(dividend == -2147483648) return 1;
    //         else return 0;

    //     }
    //     if(dividend >= 0 && divisor > 0) flag = 0;
    //     else if(dividend < 0 && divisor > 0) flag = 1;
    //     else if(dividend > 0 && divisor < 0) flag = 1;
    //     else flag = 0;
    //     if(dividend < -2147483647){
    //         dividend = 2147483647;
    //     }
    //     dividend = Math.abs(dividend);
    //     divisor = Math.abs(divisor);
    //     if(dividend < divisor) return 0;
    //     int result = 0;
    //     int judge = 0;
    //     if(origin_dividend < -2147483647)
    //     {
    //         dividend = dividend -divisor;
    //         result = result + 1;
    //         dividend = dividend + 1;
    //         while(dividend >= divisor){
    //             dividend = dividend - divisor;
    //             if(result >=2147483647) judge ++ ;
    //             else result = result + 1; 
                
    //         }
    //         // result = result - 1;
    //         if(judge > 1)
    //         {
    //             if(flag == 1) return -2147483648;
    //             else return 2147483647;
    //         } 
    //         else if(judge == 1) result = 2147483647;
    //     }
    //     else{
    //         while(dividend >= divisor){
    //             dividend = dividend - divisor;
    //             if(result >=2147483647) return 2147483647;
    //             result = result + 1; 
                
    //         }
    //         // result = result - 1;
    //     }
        
    //     if(flag == 0) return result;
    //     else return 0-result;
        
    // }
    public int divide(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        
        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;
        
        long lans = ldivide(ldividend, ldivisor);
        
        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }
    
    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;
        
        //  Find the largest multiple so that (divisor * multiple <= dividend), 
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}