class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = -1;
        
        if(gas == null || gas.length == 0) return 0;
        for(int i = 0; i < gas.length; i ++){
            if(gas[i] < cost[i]) continue;
            else{
                boolean flag = true;
                int remain = 0;
                // int current = 0;
                for(int j = 0; j < gas.length; j ++){
                    int tmp = i + j;
                    // current = tmp;
                    if(tmp>= gas.length) tmp = tmp -gas.length;
                    remain = remain + gas[tmp] - cost[tmp];
                    if(remain < 0){
                        flag = false;
                        break;
                    }
                }
                if(flag == true){
                    result = i;
                    break;
                }
            }
        }
        return result;
    }
}