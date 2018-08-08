import java.util.ArrayList;
import java.util.List;

class Solution {
    public static boolean judge(String s){
        for(int i = 0; i < s.length()/2; i ++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
    public static void cutpalindrome(List<List<String>> result, List<String> prev,String s){
        if(s.length() == 0){
            List<String> tmp = new ArrayList<String>();
            for(int i = 0; i < prev.size(); i ++){
                tmp.add(prev.get(i));
            }
            result.add(tmp);
        }
        else if(s.length() == 1){
            prev.add(s);
            List<String> tmp = new ArrayList<String>();
            for(int i = 0; i < prev.size(); i ++){
                tmp.add(prev.get(i));
            }
            result.add(tmp);
            prev.remove(prev.size() - 1);
        }
        else{
            for(int i = 1; i <= s.length(); i ++){
                String current = s.substring(0, i);
                if(judge(current)){
                    prev.add(current);
                    String tmp = s.substring(i);
                    cutpalindrome(result, prev, tmp);
                    prev.remove(prev.size() - 1);
                }
                
            }
        }
        
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> prev = new ArrayList<String>();
        cutpalindrome(result, prev, s);
        return result;
        
    }
}