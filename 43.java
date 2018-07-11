class Solution {
//     public static String add(String num1, String num2){
//         String result = "";
//         if(num1.length() > num2.length()){
//             int addpos = 0;
//             for(int i = 0; i < num2.length(); i ++){
//                 int tmpresult = num1.charAt(num1.length() - 1- i) - '0';
//                 int addnum = num2.charAt(num2.length() - 1 - i) - '0';
//                 tmpresult = tmpresult + addnum + addpos;
//                 if(tmpresult > 10){
//                     result = '0' + tmpresult - 10 + result ;
//                     addpos = 1;
//                 }
//                 else{
//                     result = '0' + tmpresult + result ;
//                     addpos = 0;
//                 }
//             }
//             if(addpos > 0){
//                 result = "1" + result;
//             }
//         }
//         else{
//             int addpos = 0;
//             for(int i = 0; i < num1.length(); i ++){
//                 int tmpresult = num2.charAt(num1.length() - 1- i) - '0';
//                 int addnum = num1.charAt(num2.length() - 1 - i) - '0';
//                 tmpresult = tmpresult + addnum + addpos;
//                 if(tmpresult > 10){
//                     result = '0' + tmpresult - 10 + result ;
//                     addpos = 1;
//                 }
//                 else{
//                     result = '0' + tmpresult + result ;
//                     addpos = 0;
//                 }
//             }
//             if(addpos > 0){
//                 result = "1" + result;
//             }

//         }
//         return result;
//     }

//     public static String singleMultipy(String num1, char num2){
//         String result = "";
//         int element2 = num2 - '0'; 
//         int addpos = 0;
//         for(int i = 0; i < num1.length(); i ++){
//             int element1 = num1.charAt(num1.length() - 1 - i) - '0';
//             int tmpresult = element2 * element1;
//             if(tmpresult > 10){
//                 addpos = tmpresult / 10;
//                 tmpresult = tmpresult - tmpresult / 10 * 10 + addpos;
//             }
//             result = '0' + tmpresult + result;
//         }
//         if(addpos > 0){
//             result = '0' + addpos +  result;
//         }
//         return result;
//     }

//     public String multiply(String num1, String num2) {
//         String result  = "" ;
//         for(int i = 0; i < num1.length(); i ++){
//             String tmp = singleMultipy(num2, num1.charAt(num1.length() - 1- i));
//             result = add(result, tmp);
//         }
//         return result;
//     }
public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] pos = new int[m + n];
   
    for(int i = m - 1; i >= 0; i--) {
        for(int j = n - 1; j >= 0; j--) {
            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
            int p1 = i + j, p2 = i + j + 1;
            int sum = mul + pos[p2];

            pos[p1] += sum / 10;
            pos[p2] = (sum) % 10;
        }
    }  
    
    StringBuilder sb = new StringBuilder();
    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
}
}

