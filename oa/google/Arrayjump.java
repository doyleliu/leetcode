class Solution {
    public int solution(int[] A)
    {
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
        int cnt = 1;
        for(int i = A.length - 2; i >=0; i --){
            int step = 0;
            while(i != A.length - 1){
                step = step + 1;
                if(step % 2 == 1){
                    int j = i + 1;
                    for(; j < A.length - 1; j ++){
                        if(A[j] > A[i]){

                            break;
                        }
                    }
                    if(j == A.length - 1 && A[j] <= A[i]) break;
                    else if(even[j] == true){
                        odd[i] = true;
                        cnt = cnt + 1;
                        break;
                    }
                    else{
                        break;
                    }
                }
                else{
                    int j = i + 1;
                    for(; j < A.length - 1; j ++){
                        if(A[j] < A[i]){

                            break;
                        }
                    }
                    if(j == A.length - 1 && A[j] >= A[i]) break;
                    else if(odd[j] == true){
                        even[i] = true;
                        cnt = cnt + 1;
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