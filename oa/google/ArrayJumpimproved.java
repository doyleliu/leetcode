import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

class Solution {
    public int solution(int[] A)
    {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        if(A.length == 0) return 0;
        else if(A.length == 1) return 1;
        boolean[] odd= new boolean [A.length];
        boolean[] even= new boolean [A.length];
        for(int i = 0; i < A.length; i ++){
            odd[i] = false;
            even[i] = false;
        }
        odd[A.length - 1] = true;
        even[A.length - 1] = true;
        map.put(A.length - 1, A[A.length - 1]);
        int cnt = 1;
        for(int i = A.length - 2; i >=0; i --){
            map.put(i, A[i]);
            int step = 0;
            while(i != A.length - 1){
                step = step + 1;
                if(step % 2 == 1){
                    // int j = i + 1;
                    // for(; j < A.length - 1; j ++){
                    //     if(A[j] > A[i]){

                    //         break;
                    //     }
                    // }
                    if(map.lowerEntry(i) != null){
                        if( even[map.lowerEntry(i).getKey()] == true){
                            odd[i] = true;
                            cnt ++;
                        }
                        break;
                    }
                    else{
                        break;
                    }
                }
                else{
                    // int j = i + 1;
                    // for(; j < A.length - 1; j ++){
                    //     if(A[j] < A[i]){

                    //         break;
                    //     }
                    // }
                    // if(j == A.length - 1 && A[j] >= A[i]) break;
                    // else if(odd[j] == true){
                    //     even[i] = true;
                    //     cnt = cnt + 1;
                    //     break;
                    // }
                    // else{
                    //     break;
                    // }
                    if(map.floorEntry(i) != null){
                        if( odd[map.floorEntry(i).getKey()] == true){
                            even[i] = true;
                            cnt ++;
                        }
                        break;
                    }
                    else{
                        break;
                    }

                }
            }
        }
        return cnt;
    }
}