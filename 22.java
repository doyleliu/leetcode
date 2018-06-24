import java.util.ArrayList;
import java.util.List;

class Solution {
    public void generate(List<String> result, String str,int left, int right, int nums){
        if(str.length() == 2 * nums){
            result.add(str);
            return;
        }
        if(left < nums){
            generate(result, str+'(', left+1, right, nums);
        }
        if(right < left){
            generate(result, str+')', left, right+1, nums);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        String str = "";
        generate(result, str, 0, 0, n);
        return result;
        
            
    }
}