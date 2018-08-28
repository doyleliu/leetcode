import java.util.ArrayList;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // boolean[] flag =  new boolean[s.length() + 1];
        // Set<String> set = new HashSet<String>();
        // List<List<String>> result = new ArrayList<List<String>>();
        // List<String> init = new ArrayList<String>();
        // // result.add(init);
        // set.addAll(wordDict);
        // flag[0] = true;
        // for(int i = 0; i <= s.length(); i ++){
        //     List<String> tmplist = new ArrayList<String>();
        //     for(int j = i - 1; j >=0; j --){
        //         boolean tmp = flag[j] && set.contains(s.substring(j,i));
        //         if(tmp){
        //             flag[i] = true; 
        //             if(j == 0) tmplist.add(s.substring(j,i));
        //             else{
        //                 for(int k = 0; k < result.get(j).size(); k ++){
        //                     tmplist.add(result.get(j).get(k) + " "  + s.substring(j,i));
        //                 }
        //             }

        //         } 
        //     }
        //     result.add(tmplist);
        // }
        // if(flag[s.length()]) return result.get(s.length());
        // else return init;
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s)) 
            return map.get(s);
            
        LinkedList<String>res = new LinkedList<String>();     
        if (s.length() == 0) {
            res.add("");
            return res;
        }               
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) 
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
            }
        }       
        map.put(s, res);
        return res;
    }
}