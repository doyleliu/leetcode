class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        s = s.toUpperCase();
       
        int i = 0;
        int j = s.length() - 1;
        while(i < s.length() && s.charAt(i) == ' '  ) i ++;
        while(j >= 0 && s.charAt(j) == ' ') j --;
        boolean result = true;
        while(i <= j){
            if(! Character.isLetterOrDigit(s.charAt(i)) ){
                i = i + 1;
            }
            else if(! Character.isLetterOrDigit(s.charAt(j))){
                j = j - 1;
            }
            else if(s.charAt(i) != s.charAt(j)){
                result = false;
                break;
            }
            else{
                i = i + 1;
                j = j - 1;
            }
        }
        return result;       
    }
}