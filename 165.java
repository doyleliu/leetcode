class Solution {
    public int compareVersion(String version1, String version2) {
        int[] v1 = new int[1000];
        int[] v2 = new int[1000];
        for(int i = 0 ; i < 1000; i ++){
            v1[i] = 0;
            v2[i] = 0;
        } 

        int i = 0 ;
        int cnt1 = 0;
        int cnt2 = 0;
        while(i < version1.length()){
            if(version1.charAt(i)!= '.'){
                v1[cnt1] = v1[cnt1] * 10 + (version1.charAt(i) - '0');
            }
            else cnt1 ++;
            i ++;
        }
        i = 0;
        while(i < version2.length()){
            if(version2.charAt(i)!= '.'){
                v2[cnt2] = v2[cnt2] * 10 + (version2.charAt(i) - '0');
            }
            else cnt2 ++;
            i ++;
        }

        for(int j = 0 ; j < 1000; j ++){
            if(v1[j ] < v2[j]) return -1;
            else if(v1[j ] > v2[j]) return 1;
        }
        return 0;
        // if(cnt1 == cnt2) return 0;
        // else if(cnt1 > cnt2) return 1;
        // else return - 1;

    }
}