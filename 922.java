class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        int j = A.length - 1;
        while(j >= 0 &&(odd <=A.length - 1)  &&(even <=A.length - 2)){
            if(A[j] % 2 == 0){
                if(A[even] % 2 == 0){
                    even += 2;
                }
                else{
                    int tmp = A[even];
                    A[even] = A[j];
                    A[j] = tmp;
                    if(j % 2 != 0){
                        // even += 2; 
                        j --;
                    } 
                }
            }
            else{
                if(A[odd] % 2 == 1){
                    odd += 2;
                }
                else{
                    int tmp = A[odd];
                    A[odd] = A[j];
                    A[j] = tmp;
                    if(j % 2 == 0){
                        // odd = odd + 2;
                        j --;
                    } 
                }
            }

        }
        return A;
    }
}