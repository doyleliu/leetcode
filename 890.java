import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<String>();

        for(int i = 0 ; i < words.length; i ++){
            int[] dict = new int[26];
            boolean[] dict2 = new boolean[26];
            boolean flag = true;
            for(int j = 0; j < 26; j ++){
                dict[j] = -1;
                dict2[j] = false;
            } 
            if(words[i].length() != pattern.length()){
                flag = false;
                continue;
            }
            for(int j = 0; j < pattern.length(); j ++){
                char current_pattern = pattern.charAt(j);
                if(dict[current_pattern - 'a'] != -1){
                    if(dict[current_pattern - 'a'] != (words[i].charAt(j) - 'a')){
                        flag = false;
                        break;
                    }
                }
                else{
                    if(dict2[words[i].charAt(j) - 'a'] == true){
                        flag = false;
                        break;
                    }
                    else{
                        dict[current_pattern - 'a'] = words[i].charAt(j) - 'a';
                        dict2[words[i].charAt(j) - 'a'] = true;
                    }
                }
            }

            if(flag == true){
                result.add(words[i]);
            }

        }
        return result;
    }
}