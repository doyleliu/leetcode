import com.sun.org.apache.xml.internal.serializer.ElemDesc;

class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int symmetry = 0;
        int down_final =0;
        int up_final = 0;
        if(s.length() == 1) return s.substring(0, 1);
        for(symmetry = 0; symmetry < 2 * s.length() ; symmetry++)
        {
            if(symmetry / 2 * 2 != symmetry)
            {
                int down = symmetry/2;
                int up = symmetry/2 +1;
                while(down >= 0 && up < s.length()){
                    if(s.charAt(down) == s.charAt(up))
                    {
                        if((up - down + 1)> max){
                            max = up - down + 1 ;
                            down_final = down;
                            up_final = up;
                        }
                        down --;
                        up ++;
                        
                        
                    }
                    else break;
                }
            }
            else{
                int down = symmetry/2 - 1;
                int up = symmetry/2 + 1;
                while(down >= 0 && up < s.length()){
                    if(s.charAt(down) == s.charAt(up))
                    {
                        if((up-down + 1) > max){
                            max  = up - down + 1;
                            down_final = down;
                            up_final = up;
                        }
                        down --;
                        up ++;
                        
                    }
                    else break;
                }   
            }
        }
        return s.substring(down_final, up_final+1);    
    }
}