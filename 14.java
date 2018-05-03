class Solution {
    public String longestCommonPrefix(String[] strs) {
        char tmp;
        String outPut = "";
        boolean flag = true;
        int cnt =0;
        if(strs.length == 0) return outPut;
        while(flag){
            if(cnt < strs[0].length()) tmp = strs[0].charAt(cnt);
            else{
                flag = false;
                break;
            } 
            for(int i = 0; i < strs.length; i ++){
                if(cnt >= strs[i].length() || tmp != strs[i].charAt(cnt)) flag = false;
            }
            if(flag == false) break;
            else{
                cnt ++;
                outPut = outPut + tmp;
            }
        }
        return outPut;       
    }
}