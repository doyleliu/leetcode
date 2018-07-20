import java.util.List;
import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        int i = 0;
        Stack<String> tmp = new Stack<String>();
        for(; i < path.length()-1; i ++){
            int left = i;
            int right = i;
            if(path.charAt(i) == '/'){
                // if(i >= path.length() - 1) break;
                while(path.charAt(i) == '/'){
                    i ++;
                    if(i >= path.length()) break;
                }
                if(i >= path.length()) break;
                left = i;
                while(path.charAt(i) != '/'){
                    i ++;
                    if(i >= path.length()) break;
                }
                if(i >= path.length() && left >= path.length()) break;
                right = i;
                String compare = path.substring(left, right);
                if(!compare.equals("..") && !compare.equals(".")){
                    tmp.push(compare);
                }
                else if(compare.equals("..")){
                    if(tmp.size() > 0) tmp.pop();
                }
                i = i -1;
            }
        }
        String result = "";
        String tmpstring;
        i = 0;
        if(tmp.size() <= 0) return "/";
        for(; i < tmp.size(); i ++){
            tmpstring = tmp.get(i);
            result = result + '/' + tmpstring;
            // result = result + " " +  tmpstring;
        } 
        return result;   
    }
}