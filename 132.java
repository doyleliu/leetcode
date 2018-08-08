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

    public int minCut(String s) {
        
        // List<List<String>> result = new ArrayList<List<String>>();
        // List<String> prev = new ArrayList<String>();
        // cutpalindrome(result, prev, s);
        // if(result.size() == 0) return 0;
        // int min = result.get(0).size() - 1;
        // for(int i = 0; i < result.size(); i ++){
        //     if(result.get(i).size() - 1 < min){
        //         min = result.get(i).size() - 1;
        //     }
        // }
        // return min;
        char[] c = s.toCharArray();
    int n = c.length;
    int[] cut = new int[n];
    boolean[][] pal = new boolean[n][n];
    
    for(int i = 0; i < n; i++) {
        int min = i;
        for(int j = 0; j <= i; j++) {
            if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                pal[j][i] = true;  
                min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
            }
        }
        cut[i] = min;
    }
    return cut[n - 1];
        
    }
}