class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        int max = 0;
        int start=0, end=0;
        boolean[] flag = new boolean [127];
        for(i =0; i< s.length(); i ++){     
            for(int tmp =0; tmp < flag.length; tmp ++){
                flag[tmp] = true;
            }
            // substring.append(s[i]);
            for(j = i; j < s.length(); j++){
                int num = s.charAt(j) - (char)0;
                if(flag[num] == false){
                    if(max == j - i - 1 )
                    {
                        start = i;
                        end = j - 1;
                    }
                    break;
                    
                }
                else{
                    flag[num] = false;
                    if(j - i > max) max ++;
                }
            }
            
        }
        if(s.length() == 0) return max;
        return max+1;
    }
}