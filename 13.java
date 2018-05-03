class Solution {
    public int romanToInt(String s) {
        int tmp = 0;
        int romanInt = 0;
        int pos = 0;
        while(pos < s.length()){
            switch(s.charAt(pos)){
                case 'I' : 
                    if(pos + 1 < s.length() && s.charAt(pos + 1) == 'I'){
                        while(pos + 1 < s.length() && s.charAt(pos) == 'I'){
                            romanInt = romanInt + 1;
                            pos ++;
                        }
                        // romanInt = romanInt + 1;
                    }
                    else if(pos + 1 < s.length() && s.charAt(pos+ 1) == 'V'){
                        romanInt = romanInt + 4;
                        pos = pos + 2;
                    }
                    else if(pos + 1 < s.length() && s.charAt(pos+ 1) == 'X'){
                        romanInt = romanInt + 9;
                        pos = pos + 2;
                    }
                    else{
                        romanInt = romanInt + 1;
                        pos ++;
                    } 
                    break;
                case 'X' : 
                    if(pos + 1 < s.length() && s.charAt(pos+ 1) == 'X'){
                        while(pos + 1 < s.length() &&  s.charAt(pos) == 'X'){
                            romanInt = romanInt + 10;
                            pos ++;
                        }
                        // romanInt = romanInt + 10;
                    }
                    else if(pos + 1 < s.length() && s.charAt(pos + 1) == 'L'){
                        romanInt = romanInt + 40;
                        pos = pos + 2;
                    }
                    else if(pos + 1 < s.length() && s.charAt(pos+ 1) == 'C'){
                        romanInt = romanInt + 90;
                        pos = pos + 2;
                    }
                    else{
                        romanInt = romanInt + 10;
                        pos ++;
                    } 
                    break;
                case 'C' : 
                    if(pos + 1 < s.length() && s.charAt(pos + 1) == 'C'){
                        while(pos + 1 < s.length() &&  s.charAt(pos) == 'C'){
                            romanInt = romanInt + 100;
                            pos ++;
                        }
                        // romanInt = romanInt + 100;
                    }
                    else if(pos + 1 < s.length() && s.charAt(pos + 1) == 'D'){
                        romanInt = romanInt + 400;
                        pos = pos + 2;
                    }
                    else if(pos + 1 < s.length() && s.charAt(pos+ 1) == 'M'){
                        romanInt = romanInt + 900;
                        pos = pos + 2;
                    }
                    else{
                        romanInt = romanInt + 100;
                        pos ++;
                    } 
                    break;
                case 'M' : 
                    if(pos + 1 < s.length() && s.charAt(pos + 1) == 'M'){
                        while(pos + 1 < s.length() && s.charAt(pos) == 'M'){
                            romanInt = romanInt + 1000;
                            pos ++;
                        }
                        // romanInt = romanInt + 1000;
                    }
                    else{
                        romanInt = romanInt + 1000;
                        pos ++;
                    } 
                    break;
                // > 5
                case 'V' : 
                    if(pos + 1 < s.length() && s.charAt(pos + 1) == 'I'){
                        romanInt = romanInt + 5;
                        pos ++ ;
                        while(pos < s.length() && s.charAt(pos) == 'I'){
                            romanInt = romanInt + 1;
                            pos ++;
                        }
                    }
                    else{
                        romanInt = romanInt + 5;
                        pos ++;
                    }
                    break;
                case 'L' : 
                    if(pos + 1 < s.length() && s.charAt(pos + 1) == 'X'){
                        romanInt = romanInt + 50;
                        pos ++;
                        while(pos < s.length() && s.charAt(pos) == 'X'){
                            romanInt = romanInt + 10;
                            pos ++;
                        }
                    }
                    else{
                        romanInt = romanInt + 50;
                        pos ++;
                    }
                    break;
                case 'D' : 
                    if(pos + 1 < s.length() && s.charAt(pos + 1) == 'C'){
                        romanInt = romanInt + 500;
                        pos ++;
                        while(pos < s.length() && s.charAt(pos) == 'C'){
                            romanInt = romanInt + 100;
                            pos ++;
                        }
                    }
                    else{
                        romanInt = romanInt + 500;
                        pos ++;
                    }
                    break;
            }
        }
        return romanInt;
    }
}