class Solution {
    public boolean isPalindrome(int x) {
        String s = "";
        int tmp = x;
        int remain = 0;
        if(tmp == - 2147483648) return false;
        if(tmp < 0) tmp = 0 - tmp;
        else{
            if(tmp == 0) return true;
        }
        while(tmp > 0){
            remain = tmp - tmp / 10 * 10;
            s = s + remain;
            tmp = tmp / 10;
        }
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}