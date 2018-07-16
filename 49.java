import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<List<Integer>> compare = new ArrayList<List<Integer>>();

        for(int i = 0; i < strs.length; i ++){
            List<Integer> tmpnumber = new ArrayList<Integer>();
            List<String> tmpstring = new ArrayList<String>();
            String tmpstr = strs[i];
            for(int j = 0; j < tmpstr.length(); j ++){
                tmpnumber.add(tmpstr.charAt(j)- 'a');
            }
            Collections.sort(tmpnumber);
            boolean flag = false;
            int k = 0;
            for(k = 0; k < compare.size(); k ++){
                if(compare.get(k).equals(tmpnumber)){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                tmpstring.add(strs[i]);
                compare.add(tmpnumber);
                result.add(tmpstring);
            }
            else if(compare.size() > 0){
                result.get(k).add(strs[i]);
            }
        }
        return result;
    }
}