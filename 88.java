class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = 0;
        if(n == 0) return;
        else if(m == 0){
            for(int i = 0; i < n; i ++){
                nums1[i] = nums2[i];
            }
            return;
        }
        for(int i = 0; i < m ; i ++){
            nums1[m+n - 1 - i] = nums1[m-1-i];
        }
        int tmp1 = n;
        int tmp2 = 0;
        for(int i = 0; i < m+n; i++){
            if(nums1[tmp1] > nums2[tmp2]){
                nums1[pos] = nums2[tmp2];
                pos ++;
                tmp2 ++;
            }
            else{
                nums1[pos] = nums1[tmp1];
                pos++;
                tmp1++;
            }
            if(tmp1 >= m+n || tmp2 >= n){
                break;
            }
        }
        if(tmp1 >= m+n){
            for(int i = tmp2; i < n; i ++){
                nums1[pos] = nums2[i];
                pos++;
            }
        }
        
    }
}