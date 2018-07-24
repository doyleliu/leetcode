import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void judge(List<String> result, String s,String prev , int remain){
        if(remain == 0){
            int tmp = Integer.parseInt(s);
            if(tmp < 256){
                if(s.length()>1 && s.charAt(0) == '0') return;
                prev = prev + s;
                int pos = s.length();
                result.add(prev);
                prev = prev.substring(0, prev.length() - pos - 2);
            }
        }
        else{
            for(int i = 0; i < s.length() - remain; i++){
                int tmp = Integer.parseInt(s.substring(0,i+1));
                if(tmp < 256){
                    if(i>0 && s.charAt(0) == '0') break;
                    prev = prev + s.substring(0,i+1) + ".";
                    judge(result, s.substring(i+1), prev, remain - 1);
                    prev = prev.substring(0, prev.length() - i - 2);
                }
                else{
                    break;
                }  
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<String>();
        if(s.length() > 12) return result;
        String prev = "";
        judge(result, s, prev, 3);
        return result;

    }
}