import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        // boolean flag = false;
        // for(int i = 0; i < wordDict.size(); i ++){
        //     if(wordDict.get(i).length() > s.length()) continue;
        //     else if(wordDict.get(i).equals(s.substring(0, wordDict.get(i).length()))){
        //         flag = wordBreak(s.substring(wordDict.get(i).length()), wordDict);
        //         if(flag == true) break;
        //     }
        // }
        // return flag;
        boolean[] flag =  new boolean[s.length() + 1];
        Set<String> set = new HashSet<String>();
        set.addAll(wordDict);
        flag[0] = true;
        for(int i = 0; i <= s.length(); i ++){
            for(int j = i - 1; j >=0; j --){
                flag[i] = flag[j] && set.contains(s.substring(j,i));
                if(flag[i]) break;
            }
        }
        return flag[s.length()];
    }
}