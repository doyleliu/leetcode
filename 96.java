import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void getnum(List<Integer> result, List<Integer> num,int empty, int oneside, int remain){
        if(remain == 1){
            int tmp = result.get(0) + 1;
            result.remove(0);
            result.add(tmp);
        }
        else{
            // for(int i = 0; i < oneside; i ++){
            //     getnum(result, empty + 1, oneside-1, remain-1);
            // }
            // for(int j = 0; j < empty; j ++){
            //     getnum(result, empty, oneside+1, remain-1);
            // }
        }
    }
    public int numTrees(int n) {
        // List<Integer> result = new ArrayList<Integer>();
        // List<Integer> num = new ArrayList<Integer>();
        // for(int i = 1; i <= n; i ++){
        //     num.add(i);
        // }
        // if(n == 0) return 1;
        // if(n == 1) return 1;
        // result.add(0);
        // for(int i = 0; i < n ; i ++){
        //     num.remove(i);
        //     getnum(result,num, 1, 0, n-1);
        //     num.add(i, i+1);
        // }
        
        // return result.get(0);
        int [] G = new int[n+1];
        G[0] = G[1] = 1;
    
        for(int i=2; i<=n; ++i) {
    	    for(int j=1; j<=i; ++j) {
    		    G[i] += G[j-1] * G[i-j];
    	    }
        }

        return G[n];

    }
}