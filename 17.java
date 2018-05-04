import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> addCombine(String digits, List<String> prev){
        List<String> result = new ArrayList<String>();
        for(int i =0 ; i < digits.length(); i ++){
            if(prev.isEmpty()){
                result.add(""+digits.charAt(i));
            }
            for(String str:prev){
                result.add(str + digits.charAt(i));
            }
        }
        return result; 
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.isEmpty()) return result;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
        for(int i = 0 ; i < digits.length(); i ++){
            int tmp = digits.charAt(i) - '0';
            String tmp_digits = mapping[tmp];
            result = addCombine(tmp_digits, result);
        }
        return result;
    }
}