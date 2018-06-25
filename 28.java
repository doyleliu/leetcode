class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == ""|| needle.length() == 0) return 0;
        if(haystack == "") return -1;
        for(int i = 0; i < haystack.length(); i++){
            boolean flag = true;
            for(int j = 0; j< needle.length();j ++){
                if(i + needle.length() > haystack.length()){
                    flag =false;
                    break;
                }
                if(haystack.charAt(i+j)!= needle.charAt(j)){
                    flag =false;
                    break;
                }
            }
            // if(flag == true && haystack.length() == needle.length()) return 0;
            if(flag == true) return i;
        }
        return -1;
    }
}