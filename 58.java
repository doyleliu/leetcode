class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        if(s == null || s.length() == 0) return 0; 
        int i = s.length() - 1;
        char tmp = s.charAt(i);
        while(tmp == ' '){
            i = i - 1;
            if(i < 0 ) break;
            tmp = s.charAt(i);
        }
        while(i >= 0 && tmp != ' '){
            length = length + 1;
            i = i - 1;
            if(i >= 0) tmp = s.charAt(i);
            
        }
        return length;
    }
}