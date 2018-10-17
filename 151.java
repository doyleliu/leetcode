public class Solution {
    public String reverseWords(String s) {
        String result = "";
        String[] words = s.split(" ");
        for(int i = 0; i < words.length; i ++){
            if(i == 0 || result.equals("")) result = words[i];
            else if(words[i].equals("")) continue;
            else result = words[i] + " " + result;
        }
        return result;
    }
}