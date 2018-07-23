import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void decode(List<Integer> result, String s){
        if(s.charAt(0) == '0') return;
        if(s.length() == 1){
            int tmp = result.get(0) + 1;
            result.remove(result.size() - 1);
            result.add(tmp);
        }
        else if(s.length() == 2){
            int a = s.charAt(0) - '0';
            int b = s.charAt(1) - '0';
            int num = a * 10 + b;
            
            if(b == 0){
                if(num > 26) return;
                int tmp = result.get(0) + 1;
                result.remove(result.size() - 1);
                result.add(tmp);
            }
            else if(num <= 26){
                int tmp = result.get(0) + 2;
                result.remove(result.size() - 1);
                result.add(tmp);
            }
            else{
                int tmp = result.get(0) + 1;
                result.remove(result.size() - 1);
                result.add(tmp);
            }
        }
        else{
            int a = s.charAt(0) - '0';
            int b = s.charAt(1) - '0';
            int num = a*10 + b;
            if(s.charAt(2) == '0'){
                decode(result, s.substring(1, s.length()));
            }
            else if(s.charAt(1) == '0'){
                if(num > 26) return;
                decode(result, s.substring(2, s.length()));
            }
            else if(num <= 26){
                decode(result, s.substring(1, s.length()));
                decode(result, s.substring(2, s.length()));
            }
            else{
                decode(result, s.substring(1, s.length()));
            }
        }
    }

    public int numDecodings(String s) {
        // List<Integer> result = new ArrayList<Integer>();
        // result.add(0);
        // if(s == null || s.length() == 0) return 0;
        // if(s.charAt(0) == '0') return 0;
        // if(s.length() <= 1) return 1;
        // decode(result, s);
        // return result.get(0);
        int n = s.length();
        if (n == 0) return 0;
        
        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
        
        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
        
        return memo[0];
    }
}