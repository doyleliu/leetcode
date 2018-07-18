class Solution {
    public int[] plusOne(int[] digits) {
        int addon = 0;

        digits[digits.length - 1] = digits[digits.length - 1] + 1; 
        for(int i = digits.length - 1; i >= 0; i --){
            digits[i] = digits[i] + addon;
            if(digits[i] == 10)
            {
                digits[i] = 0;
                addon = 1;
            }
            else{
                addon = 0;
            } 
        }
        if(addon == 1){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for(int j = 0; j < digits.length;j++){
                result[j+1] = digits[j];
            }
            return result;
        }
        else{
            return digits;
        }
        
    }
}