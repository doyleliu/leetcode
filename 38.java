class Solution {
    public static String count(String num){
        int i =0 ;
        String result = "";
        while(i < num.length()){
            char tmp = num.charAt(i);
            int count = 0;
            while(i < num.length() &&  num.charAt(i) == tmp ){
                count ++;
                i++;
            }
            result = result + count + tmp;
        }
        return result;
    }

    public String countAndSay(int n) {
        if(n ==1) return "1";
        String tmp = "1";
        while(n > 1){
            tmp = count(tmp);
            n = n - 1;
        }
        return tmp;

    }
}