class Solution {
    public String intToRoman(int num) {
        int tmp = 0;
        int current = num;
        int pos = 0;
        String Roman = "";
        while(current != 0){
            tmp = current - current / 10 * 10;
            if(tmp == 4){
                switch(pos){
                    case 0: Roman = "IV" + Roman;break;
                    case 1: Roman = "XL" + Roman;break;
                    case 2: Roman = "CD" + Roman;break;
                }  
            }
            else if(tmp == 9){
                switch(pos){
                    case 0: Roman = "IX" + Roman;break;
                    case 1: Roman = "XC" + Roman;break;
                    case 2: Roman = "CM" + Roman;break;
                }
            }
            else if(tmp == 5){
                switch(pos){
                    case 0: Roman = "V" + Roman;break;
                    case 1: Roman = "L" + Roman;break;
                    case 2: Roman = "D" + Roman;break;
                }
            }
            else if(tmp > 5){
                for(int i =5; i < tmp; i ++){
                    switch(pos){
                        case 0: Roman = "I" + Roman;break;
                        case 1: Roman = "X" + Roman;break;
                        case 2: Roman = "C" + Roman;break;
                    }
                    
                }
                switch(pos){
                    case 0: Roman = "V" + Roman;break;
                    case 1: Roman = "L" + Roman;break;
                    case 2: Roman = "D" + Roman;break;    
                }
            }
            else{
                for(int i =0; i < tmp; i ++){
                    switch(pos){
                        case 0: Roman = "I" + Roman;break;
                        case 1: Roman = "X" + Roman;break;
                        case 2: Roman = "C" + Roman;break;
                        case 3: Roman = "M" + Roman;break;
                    }
                }
            }
            current = (current - tmp) / 10;
            pos ++ ;
        }
        return Roman;
    }
}