class Solution {
    public String addBinary(String a, String b) {
        int max = Math.max(a.length(), b.length()) + 1;
        int[] result = new int[max];
        if(a.length() > b.length()){
            int addon = 0;
            int i = 0;
            for(i = 0 ; i < b.length() ; i ++ ){
                if((a.charAt(a.length() - 1- i) - '0') + (b.charAt(b.length() - 1 -i)-'0') + addon >= 2){
                    result[result.length - 1 - i] = (a.charAt(a.length() - 1- i) - '0') + (b.charAt(b.length() - 1 -i)-'0') + addon - 2;
                    addon = 1;
                }
                else{
                    result[result.length - 1 - i] = (a.charAt(a.length() - 1- i) - '0') + (b.charAt(b.length() - 1 -i)-'0') + addon;
                    addon = 0;
                }
            }
            for(; i < a.length(); i ++){
                if((a.charAt(a.length() - 1- i) - '0') + addon >= 2){
                    result[result.length - 1- i] = (a.charAt(a.length() - 1- i) - '0') + addon -2;
                    addon = 1;
                }
                else{
                    result[result.length - 1- i] = (a.charAt(a.length() - 1- i) - '0') + addon;
                    addon = 0;
                }

            }
            if(addon == 1){
                result[0] = 1;
            }
            else{
                result[0] = 0;
            }
        }
        else{
            int addon = 0;
            int i = 0;
            for(i = 0 ; i < a.length() ; i ++ ){
                if((a.charAt(a.length() - 1- i) - '0') + (b.charAt(b.length() - 1 -i)-'0') + addon >= 2){
                    result[result.length - 1 - i] = (a.charAt(a.length() - 1- i) - '0') + (b.charAt(b.length() - 1 -i)-'0') + addon - 2;
                    addon = 1;
                }
                else{
                    result[result.length - 1 - i] = (a.charAt(a.length() - 1- i) - '0') + (b.charAt(b.length() - 1 -i)-'0') + addon;
                    addon = 0;
                }
            }
            for(; i < b.length(); i ++){
                if((b.charAt(b.length() - 1- i) - '0') + addon >= 2){
                    result[result.length - 1- i] = (b.charAt(b.length() - 1- i) - '0') + addon -2;
                    addon = 1;
                }
                else{
                    result[result.length - 1- i] = (b.charAt(b.length() - 1- i) - '0') + addon;
                    addon = 0;
                }

            }
            if(addon == 1){
                result[0] = 1;
            }
            else{
                result[0] = 0;
            }

        }
        String resultstring = "";
        if(result[0] == 1){
            for(int i = 0; i < result.length;i ++){
                resultstring = resultstring + (result[i]); 
            }
        }
        else{
            for(int i = 1; i < result.length;i ++){
                resultstring = resultstring + (result[i]); 
            }
        }
        return resultstring;       
    }
}