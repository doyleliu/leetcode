class Solution {
    public String convert(String s, int numRows) {
        if(s.length() == 0) return "";
        if(numRows == 1) return s;
        char[] zigzag = new char[s.length()];
        int pos = 0;
        for(int i = 0; i < numRows; i ++)
        {
            if(i == 0)
            {
                int num = 0;
                while(num < s.length()){
                    zigzag[pos] = s.charAt(num);
                    num = num + 2* numRows - 2;
                    pos = pos + 1;
                }
            }
            else if( i == numRows - 1)
            {
                int num = numRows - 1;
                while(num < s.length())
                {
                    zigzag[pos] = s.charAt(num);
                    num = num + 2 * numRows - 2;
                    pos = pos + 1;
                }
            }
            else{
                int num = i;
                while(num < s.length()){
                    zigzag[pos] = s.charAt(num);
                    num = num + 2 * numRows - 2 - 2 * i;
                    pos = pos + 1;
                    if(num < s.length()){
                        zigzag[pos] = s.charAt(num);
                        num = num + 2 * i;
                        pos = pos + 1;
                    }
                }
            }
        }
        String output = "";
        for(int i =0 ; i < zigzag.length; i ++ ){
            output = output + zigzag[i];
        }
        return output;
    }
}