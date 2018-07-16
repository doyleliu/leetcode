import java.util.Arrays;

class Solution {
    public String getPermutation(int n, int k) {
        int[] tmp = new int [n];
        for(int i = 0; i < n; i ++) {
            tmp[i] = i + 1;
        }
        for(int j = k-1; j >0; j --){
            int min = n;
            // int pos = n-1;
            int posb = n-1;
            int a;
            for(a = n-1 ; a >=1; a --){
                if(tmp[a - 1] < tmp[a]){
                    // int change = tmp[a -1];
                    // tmp[a - 1] = max;
                    // tmp[pos] = change;
                    break;

                }
            }
            int b;
            for(b = a; b < n; b ++){
                if(tmp[b] <= min && tmp[b] > tmp[a -1] ){
                    min = tmp[b];
                    posb = b;
                    
                }
            }
            int change = tmp[a-1];
            tmp[a-1] = min;
            tmp[posb] = change;

            Arrays.sort(tmp, a , n);
        }
        String result = "";
        for(int i = 0; i < n; i ++){
            result = result + tmp[i];
        }   
        return result;
    }
}