import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> queue = new Stack<Character>();
        for(int i = 0; i < s.length(); i++ ){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                queue.push(s.charAt(i));
            }
            else{
                if(queue.size() == 0){return false;}
                char elem = queue.pop();
                if(s.charAt(i) == ')'){
                    if(elem != '('){return false;}
                }
                else if(s.charAt(i) == '}'){
                    if(elem != '{'){return false;}
                }
                else{
                    if(elem != '['){return false;}
                }
            }
        }
        if(queue.size() > 0){return false;}
        return true;
    }
}